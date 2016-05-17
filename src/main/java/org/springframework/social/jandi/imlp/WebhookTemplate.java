package org.springframework.social.jandi.imlp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.social.jandi.WebhookOperations;
import org.springframework.social.jandi.type.ConnectInfo;
import org.springframework.web.client.RestOperations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-05-17.
 */
public class WebhookTemplate implements WebhookOperations {

    private String webhookUrl;
    private RestOperations restOperations;
    private ObjectMapper objectMapper;

    public WebhookTemplate(String webhookUrl, RestOperations restOperations, ObjectMapper objectMapper) {
        this.webhookUrl = webhookUrl;
        this.restOperations = restOperations;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean sendMessage(String body, String connectColor, List<ConnectInfo> connectInfos) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("body", body);
        params.put("connectColor", connectColor);
        params.put("connectInfo", connectInfos);

        String requestJson = null;
        try {
            requestJson = objectMapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/vnd.tosslab.jandi-v2+json");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(requestJson, httpHeaders);

        ResponseEntity<String> responseEntity = this.restOperations.postForEntity(webhookUrl, httpEntity, String.class);
        return responseEntity.getStatusCode() == HttpStatus.OK;
    }

}

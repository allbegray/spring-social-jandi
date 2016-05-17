package org.springframework.social.jandi.imlp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.social.jandi.WebhookOperations;
import org.springframework.social.jandi.type.ConnectInfo;
import org.springframework.social.jandi.type.JandiMessage;
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
    public boolean sendMessage(JandiMessage message) {
        String requestJson = null;
        try {
            requestJson = objectMapper.writeValueAsString(message);
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

    @Override
    public boolean sendMessage(String body, String connectColor, List<ConnectInfo> connectInfos) {
        JandiMessage message = new JandiMessage();
        message.setBody(body);
        message.setConnectColor(connectColor);
        message.setConnectInfos(connectInfos);
        return sendMessage(message);
    }

}

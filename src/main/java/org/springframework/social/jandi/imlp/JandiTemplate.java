package org.springframework.social.jandi.imlp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.Object;
import org.springframework.social.jandi.Jandi;
import org.springframework.social.jandi.WebhookOperations;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

/**
 * Created by allbegray on 2016-05-17.
 */
public class JandiTemplate implements Jandi {

    private String apiUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private WebhookOperations webhookOperations;

    public JandiTemplate(String apiUrl, RestTemplate restTemplate, ObjectMapper objectMapper) {
        Assert.notNull(apiUrl);
        Assert.notNull(restTemplate);

        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper != null ? objectMapper : new ObjectMapper();
        this.webhookOperations = new WebhookTemplate(this.apiUrl, this.restTemplate, this.objectMapper);
    }

    @Override
    public WebhookOperations getWebhookOperations() {
        return webhookOperations;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
package org.springframework.social.jandi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;
import org.springframework.social.jandi.imlp.JandiTemplate;
import org.springframework.social.jandi.type.ConnectInfo;
import org.springframework.social.jandi.type.JandiMessage;
import org.springframework.social.jandi.type.JandiText;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by allbegray on 2016-05-17.
 */
public class JandiTest {

    private String apiUrl;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        this.apiUrl = "your webhook url !!";
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void basicTest() {
        Jandi jandi = new JandiTemplate(apiUrl, restTemplate, objectMapper);

        JandiMessage message = new JandiMessage();
        message.setBody(new JandiText().url("[PizzaHouse]", "http://url_to_text").text(" You have a new Pizza order."));
        message.setConnectColor("#FAC11B");
        message.addConnectInfo(new ConnectInfo("Topping", "Pepperoni", null));
        message.addConnectInfo(new ConnectInfo("Location", "Empire State Building, 5th Ave, New York", "http://url_to_text"));
        jandi.getWebhookOperations().sendMessage(message);

        jandi.getWebhookOperations().sendMessage(
                "[[PizzaHouse]](http://url_to_text) You have a new Pizza order.",
                "#FAC11B",
                Arrays.asList(
                        new ConnectInfo("Topping", "Pepperoni", null),
                        new ConnectInfo("Location", "Empire State Building, 5th Ave, New York", "http://url_to_text"))
        );

    }

}

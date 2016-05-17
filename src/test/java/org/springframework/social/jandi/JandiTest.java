package org.springframework.social.jandi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;
import org.springframework.social.jandi.imlp.JandiTemplate;
import org.springframework.social.jandi.type.ConnectInfo;
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
//        this.apiUrl = "your webhook url !!";
        this.apiUrl = "https://wh.jandi.com/connect-api/webhook/11771662/b6c0f21377100ae0b71114afc363ad86";
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void basicTest() {
        Jandi jandi = new JandiTemplate(apiUrl, restTemplate, objectMapper);
        jandi.getWebhookOperations().sendMessage(
                "[[PizzaHouse]](http://url_to_text) You have a new Pizza order.",
                "#FAC11B",
                Arrays.asList(
                        new ConnectInfo("Topping", "Pepperoni", null),
                        new ConnectInfo("Location", "Empire State Building, 5th Ave, New York", "http://url_to_text"))
        );
    }

}

[![Release](https://img.shields.io/github/release/flowctrl/spring-social-jandi.svg?label=JitPack)](https://jitpack.io/#flowctrl/slack-api)

spring-social-jandi
=============
[잔디(Jandi)](http://www.jandi.com) 커넥트, Webhook 수신 (Incoming Webhook) API Java Client

## Maven
Step 1. Add the JitPack repository to your build file
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
Step 2. Add the dependency in the form
```xml
<dependency>
    <groupId>com.github.flowctrl</groupId>
    <artifactId>spring-social-jandi</artifactId>
    <version>v1.0.0.RELEASE</version>
</dependency>
```

## Change Logs

## How to use
```java
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
```

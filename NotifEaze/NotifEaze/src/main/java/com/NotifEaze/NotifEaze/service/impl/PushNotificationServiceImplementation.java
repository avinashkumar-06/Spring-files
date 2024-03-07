package com.NotifEaze.NotifEaze.service.impl;

import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PushNotificationServiceImplementation implements PushNotificationService {


    @Autowired
    private GupshupMock gupshupMock;



    @Override
    public BasePushNotificationResponse sendNotification(String fcmToken, String message) {

        String jsonString = gupshupMock.getPnMockedResponses().get(fcmToken);

        boolean status = false;
        String messageFromResponse = null;


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(JsonParser.Feature.ALLOW_TRAILING_COMMA, true);

            JsonNode jsonNode = objectMapper.readTree(jsonString);

             status = jsonNode.get("status").asText().equalsIgnoreCase("success");
             messageFromResponse = jsonNode.get("message").asText();

            System.out.println("Status: " + status);
            System.out.println("Message: " + messageFromResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }




        return new BasePushNotificationResponse(status,messageFromResponse);
    }
}

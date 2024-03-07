package com.NotifEaze.NotifEaze.service.impl;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.EmailService;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class EmailServiceImplementation implements EmailService {

    @Value("${vendor.name}")
    private String vendor;

    @Autowired
    private GupshupMock gupshupMock;

    @Autowired
    private KayleraMock kayleraMock;





    @Override
    public BaseEmailResponse sendEmail(String to, String subject, String body) {

        boolean status = false;
        String messageFromResponse = null;
        String jsonString;

            if ("Gupshup".equalsIgnoreCase(vendor)) {

                jsonString = gupshupMock.getEmailMockedResponses().get("Email1");
               System.out.println(jsonString);

            } else {

                jsonString = kayleraMock.getEmailMockedResponses().get("Email1");
              System.out.println(jsonString);

            }


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(JsonParser.Feature.ALLOW_TRAILING_COMMA, true);

            JsonNode jsonNode = objectMapper.readTree(jsonString);

            status = jsonNode.get("success").asText().equalsIgnoreCase("true");
            messageFromResponse = jsonNode.get("message").asText();

            System.out.println("Status: " + status);
            System.out.println("Message: " + messageFromResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }




            return new BaseEmailResponse(status,messageFromResponse);


        }





}

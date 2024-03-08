package com.NotifEaze.NotifEaze.service.impl;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.EmailService;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class EmailServiceImplementation implements EmailService {

    private final String vendor;
    private final GupshupMock gupshupMock;
    private final KayleraMock kayleraMock;

    public EmailServiceImplementation(@Value("${vendor.name}") String vendor, GupshupMock gupshupMock, KayleraMock kayleraMock) {
        this.vendor = vendor;
        this.gupshupMock = gupshupMock;
        this.kayleraMock = kayleraMock;
    }

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

package com.NotifEaze.NotifEaze.service.impl;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.dto.XmlData;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.SmsService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

@Service
public class SmsServiceImplementation implements SmsService {


    @Value("${vendor.name}")
    private String vendor;

    @Autowired
    private GupshupMock gupshupMock;

    @Autowired
    private KayleraMock kayleraMock;

    @Override
    public BaseSmsResponse sendSms(String phoneNumber, String message) {

        boolean status = false;
        String messageFromResponse = null;
        String response;


        if(vendor.equalsIgnoreCase("Gupshup")){


            /*
             I am getting message by message id and not by phone number because there is not phone number in GupshupMock class SmsMockedResponses map.
              keys are message id. There are two entries in map and to get them we have to use message id which is present as key in map.
            */
            response  = gupshupMock.getSmsMockedResponses().get("MessageId1");
            System.out.println(response);

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(JsonParser.Feature.ALLOW_TRAILING_COMMA, true);

                JsonNode jsonNode = objectMapper.readTree(response);

                status = jsonNode.get("success").asText().equalsIgnoreCase("true");
                messageFromResponse = jsonNode.get("providerResponse").asText();

                System.out.println("Status: " + status);
                System.out.println("Message: " + messageFromResponse);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{

            response = kayleraMock.getSmsMockedResponses().get(phoneNumber);
            System.out.println(response);

            XmlData xmlData = parseXml(response);
            status=xmlData.getStatus().startsWith("0");
            messageFromResponse=xmlData.getResponseMessage();

            System.out.println("Status: " + status);
            System.out.println("Message: " + messageFromResponse);

        }




        return new BaseSmsResponse(status,messageFromResponse);
    }

    @Override
    public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
        return null;
    }


    private static XmlData parseXml(String xmlString) {
        XmlData xmlData = new XmlData();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            XPathExpression statusExpression = xPath.compile("/root/status/text()");
            XPathExpression responseMessageExpression = xPath.compile("/root/responseMessage/text()");

            xmlData.setStatus((String) statusExpression.evaluate(document, XPathConstants.STRING));
            xmlData.setResponseMessage((String) responseMessageExpression.evaluate(document, XPathConstants.STRING));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return xmlData;
    }

}

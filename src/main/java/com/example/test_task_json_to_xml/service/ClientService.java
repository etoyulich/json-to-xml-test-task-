package com.example.test_task_json_to_xml.service;

import com.example.test_task_json_to_xml.dao.DocumentDao;
import com.example.test_task_json_to_xml.dao.ClientDao;
import com.example.test_task_json_to_xml.dto.ClientCreationDto;
import com.example.test_task_json_to_xml.entity.ClientEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;

@Service
public class ClientService {

    private final ClientDao clientDao;
    private final DocumentDao documentDao;

    @Autowired
    public ClientService(ClientDao clientDao, DocumentDao documentDao) {
        this.clientDao = clientDao;
        this.documentDao = documentDao;
    }

    public String createNewClient(ClientCreationDto dto) throws Exception {
        ClientEntity entity = new ClientEntity(dto);
        documentDao.save(entity.getDocument());
        clientDao.save(entity);

        JSONObject person = new JSONObject();
        JSONObject client = new JSONObject(dto);
        person.put("person", client);

        String xmlText = XML.toString(person);
       // xmlText = convertToCdata(xmlText);

        xmlText = "<![CDATA[" + xmlText + "]]";
        System.out.println(xmlText);

        String soapBody = "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <Body>\n" +
                "        <getClientRequest xmlns=\"http://www.example.com/springsoap/gen\">\n" +
                "            <xml><![CDATA[ <person>\n" +
                "<name>Тест</name>\n" +
                "<surname>Тестов</surname>\n" +
                "<patronymic>Тестович</patronymic>\n" +
                "<birthDate>1990-01-01</birthDate>\n" +
                "<gender>MAN</gender>\n" +
                "<document>\n" +
                "<series>1333</series>\n" +
                "<number>112233</number>\n" +
                "<type>PASSPORT</type>\n" +
                "<issueDate>2020-01-01</issueDate>\n" +
                "</document>\n" +
                "</person>]]></xml>\n" +
                "        </getClientRequest>\n" +
                "    </Body>\n" +
                "</Envelope>";



        HttpClient httpclient = new DefaultHttpClient();
        // You can get below parameters from SoapUI's Raw request if you are using that tool
        StringEntity strEntity = new StringEntity(soapBody, "text/xml", "UTF-8");
        // URL of request
        HttpPost post = new HttpPost("http://localhost:8181/ws");
        post.setHeader("SOAPAction", "getClientRequest");
        post.setEntity(strEntity);

        // Execute request
        HttpResponse response = httpclient.execute(post);
        HttpEntity respEntity = response.getEntity();

        String answer = "";
        if (respEntity != null) {
            answer = EntityUtils.toString(respEntity);


        } else {
            System.err.println("No Response");
        }

        entity.setAnswer(answer);
        clientDao.save(entity);

        //httpClient.close();

        return answer;
    }

}

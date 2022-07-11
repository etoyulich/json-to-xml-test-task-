package com.example.test_task_json_to_xml.service;

import com.example.test_task_json_to_xml.dao.ClientDao;
import com.example.test_task_json_to_xml.dao.DocumentDao;
import com.example.test_task_json_to_xml.dto.ClientCreationDto;
import com.example.test_task_json_to_xml.entity.ClientEntity;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
        xmlText = "![CDATA[" + xmlText + "]]";

        String soapBody = "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <Body>\n" +
                "        <getCountryRequest xmlns=\"http://www.baeldung.com/springsoap/gen\">\n" +
                "            <name><" + xmlText +  "></name>\n" +
                "        </getCountryRequest>\n" +
                "    </Body>\n" +
                "</Envelope>";


        //Заголовки
        List<Header> headers = new ArrayList<>();
        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "text/xml");
        headers.add(header);
        header = new BasicHeader("SOAPAction", "getCountryRequest");
        headers.add(header);

        HttpClient httpclient = HttpClients.custom().setDefaultHeaders(headers).build();
        StringEntity strEntity = new StringEntity(soapBody, "UTF-8");
        HttpPost post = new HttpPost("http://localhost:8181/ws");
        post.setEntity(strEntity);

        HttpResponse response = httpclient.execute(post);
        HttpEntity respEntity = response.getEntity();

        String answer = "";
        if (respEntity != null) {
            answer = EntityUtils.toString(respEntity);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(answer)));

            NodeList nodeList = doc.getElementsByTagName("ns2:country");
            answer = nodeList.item(0).getTextContent();

            System.out.println(nodeList.item(0).getTextContent());
        } else {
            System.err.println("No Response");
        }

        entity.setAnswer(answer);
        clientDao.save(entity);

        return answer;
    }

}

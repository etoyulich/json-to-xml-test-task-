package com.example.testtaskjsontoxml.service;

import com.example.testtaskjsontoxml.dao.impl.ClientDaoImpl;
import com.example.testtaskjsontoxml.dto.ClientCreationDto;
import com.example.testtaskjsontoxml.entity.ClientEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final ClientDaoImpl clientDao;
    private final ObjectMapper mapper;

    @Autowired
    public ClientService(ClientDaoImpl clientDao, ObjectMapper mapper) {
        this.clientDao = clientDao;
        this.mapper = mapper;
    }

    public String createNewClient(ClientCreationDto dto) throws Exception {

        ClientEntity entity = mapper.convertValue(dto, ClientEntity.class);
        clientDao.save(entity);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        xmlMapper.setDateFormat(df);
        String xmlText = xmlMapper.writeValueAsString(dto);

        xmlText = "![CDATA[" + xmlText + "]]";

        String soapBody = "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <Body>\n" +
                "        <getClientRequest xmlns=\"http://www.example.com/springsoap/gen\">\n" +
                "            <xml><" + xmlText +  "></xml>\n" +
                "        </getClientRequest>\n" +
                "    </Body>\n" +
                "</Envelope>";


        //Заголовки
        List<Header> headers = new ArrayList<>();
        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "text/xml");
        headers.add(header);
        header = new BasicHeader("SOAPAction", "getClientRequest");
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

            NodeList nodeList = doc.getElementsByTagName("ns2:response");
            answer = nodeList.item(0).getTextContent();
        } else {
            System.err.println("No Response");
        }

        entity.setAnswer(answer);
        clientDao.save(entity);

        return answer;
    }

}

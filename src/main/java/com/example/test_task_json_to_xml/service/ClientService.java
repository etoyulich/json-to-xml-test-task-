package com.example.test_task_json_to_xml.service;

import com.example.test_task_json_to_xml.dao.DocumentDao;
import com.example.test_task_json_to_xml.dao.ClientDao;
import com.example.test_task_json_to_xml.dto.ClientCreationDto;
import com.example.test_task_json_to_xml.entity.ClientEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
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

    public void createNewClient(ClientCreationDto dto) throws Exception {
        ClientEntity entity = new ClientEntity(dto);
        documentDao.save(entity.getDocument());
        clientDao.save(entity);

        System.out.println(entity);

        JSONObject person = new JSONObject();
        JSONObject client = new JSONObject(dto);
        person.put("person", client);

        String xmlText = XML.toString(person);

        Document doc = convertToCdata(xmlText);
        xmlText = prettyPrint(doc);

        System.out.println(xmlText);

//        try (
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            CloseableHttpResponse response = httpClient.execute(new HttpGet("http://localhost:8181/"))
//        ){
//            HttpEntity httpEntity = response.getEntity();
//
//            if(entity != null){
//                String data = httpEntity.toString();
//                System.out.println(data);
//            }
//        }catch (Throwable cause){
//            cause.printStackTrace();
//        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8181/");
        URI uri = new URIBuilder(httpGet.getURI())
                .addParameter("xml", xmlText)
                .build();
        httpGet.setURI(uri);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        httpClient.close();
        System.out.println(response);

    }

    //TODO сделать рекурсию и что вообще должно быть в этой cdata....
    private Document convertToCdata(String data) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader(data)));

        NodeList elements = doc.getDocumentElement().getChildNodes();

        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            System.out.println(node.getNodeName());
            if(node.hasChildNodes()){
                for (int j = 0; j < node.getChildNodes().getLength(); j++) {
//                    CDATASection cdata = doc.createCDATASection(node.getChildNodes().item(j).getTextContent());
//                    node.getChildNodes().item(j).setTextContent(String.valueOf(cdata));
                }
            }
            if(!node.hasChildNodes()){
//                CDATASection cdata = doc.createCDATASection(node.getTextContent());
//                elements.item(i).setTextContent(String.valueOf(cdata));
            }
        }
       // System.out.println(data);

        try {
            prettyPrint(doc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return doc;

    }

    public static String prettyPrint(Document xml) throws Exception {
        StringWriter writer = new StringWriter();
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));

        tf.transform(new DOMSource(xml), new StreamResult(writer));
        // System.out.println(out);
        return writer.toString();
    }
}

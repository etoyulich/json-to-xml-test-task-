package com.example.test_task_json_to_xml.service;

import com.example.test_task_json_to_xml.dao.DocumentDao;
import com.example.test_task_json_to_xml.dao.UserDao;
import com.example.test_task_json_to_xml.dto.ClientCreationDto;
import com.example.test_task_json_to_xml.entity.ClientEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final UserDao userDao;
    private final DocumentDao documentDao;

    @Autowired
    public ClientService(UserDao userDao, DocumentDao documentDao) {
        this.userDao = userDao;
        this.documentDao = documentDao;
    }

    public void createNewClient(ClientCreationDto dto){
        ClientEntity entity = new ClientEntity(dto);
        documentDao.save(entity.getDocument());
        userDao.save(entity);
        try (
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(new HttpGet("http://localhost:8181/"));
        ){
            HttpEntity httpEntity = response.getEntity();

            if(entity != null){
                String data = httpEntity.toString();
                System.out.println(data);
            }
        }catch (Throwable cause){
            cause.printStackTrace();
        }

    }
}

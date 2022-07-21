package com.example.testtaskjsontoxml.service;

import com.example.testtaskjsontoxml.dao.impl.ClientDaoImpl;
import com.example.testtaskjsontoxml.dto.ClientCreationDto;
import com.example.testtaskjsontoxml.entity.ClientEntity;
import com.example.testtaskjsontoxml.service.newgen.ClientInterface;
import com.example.testtaskjsontoxml.service.newgen.ClientWSService;
import com.example.testtaskjsontoxml.service.newgen.GetClientRequest;
import com.example.testtaskjsontoxml.service.newgen.GetClientResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

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

        ClientWSService service = new ClientWSService();
        ClientInterface clientService = service.getPort(ClientInterface.class);

        GetClientRequest request = new GetClientRequest();
        request.setRequest(xmlText);
        GetClientResponse body = clientService.getClientRequest(request);

        entity.setAnswer(body.getResponse());
        clientDao.save(entity);

        return body.getResponse();
    }

}

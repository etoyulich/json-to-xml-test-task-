package com.example.testtaskjsontoxml.controller;

import com.example.testtaskjsontoxml.dto.ClientCreationDto;
import com.example.testtaskjsontoxml.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final ClientService clientService;
    private static final Logger logger = LogManager.getLogger(RestController.class);

    @Autowired
    public RestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<String> createNewUser(@RequestBody @Valid ClientCreationDto dto){
        try{
            logger.info("Start converting json to xml.");
            String result = clientService.createNewClient(dto);
            logger.info("Result of converting: " + result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e){
            logger.error("Caught exception!", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

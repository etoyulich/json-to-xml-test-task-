package com.example.test_task_json_to_xml.controller;

import com.example.test_task_json_to_xml.dto.ClientCreationDto;
import com.example.test_task_json_to_xml.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final ClientService clientService;

    @Autowired
    public RestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<String> createNewUser(@RequestBody @Valid ClientCreationDto dto){
        try{
            return new ResponseEntity<>(clientService.createNewClient(dto), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

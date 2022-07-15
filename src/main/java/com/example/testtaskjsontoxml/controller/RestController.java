package com.example.testtaskjsontoxml.controller;

import com.example.testtaskjsontoxml.dto.ClientCreationDto;
import com.example.testtaskjsontoxml.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

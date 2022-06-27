package com.example.test_task_json_to_xml.controller;

import com.example.test_task_json_to_xml.dto.UserCreationDto;
import com.example.test_task_json_to_xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserService userService;

    @Autowired
    public RestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public void createNewUser(@RequestBody UserCreationDto dto){
        userService.createNewUser(dto);
    }
}

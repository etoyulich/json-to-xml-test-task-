package com.example.test_task_json_to_xml.service;

import com.example.test_task_json_to_xml.dao.DocumentDao;
import com.example.test_task_json_to_xml.dao.UserDao;
import com.example.test_task_json_to_xml.dto.UserCreationDto;
import com.example.test_task_json_to_xml.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;
    private final DocumentDao documentDao;

    @Autowired
    public UserService(UserDao userDao, DocumentDao documentDao) {
        this.userDao = userDao;
        this.documentDao = documentDao;
    }

    public void createNewUser(UserCreationDto dto){
        UserEntity entity = new UserEntity(dto);
        documentDao.save(entity.getDocument());
        userDao.save(entity);
    }
}

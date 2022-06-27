package com.example.test_task_json_to_xml.dao;

import com.example.test_task_json_to_xml.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao extends CrudRepository<UserEntity, Long> {
}

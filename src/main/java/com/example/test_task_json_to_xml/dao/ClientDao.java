package com.example.test_task_json_to_xml.dao;

import com.example.test_task_json_to_xml.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientDao extends CrudRepository<ClientEntity, Long> {
}
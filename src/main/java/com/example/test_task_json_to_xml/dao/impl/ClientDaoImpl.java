package com.example.test_task_json_to_xml.dao.impl;

import com.example.test_task_json_to_xml.dao.ClientDao;
import com.example.test_task_json_to_xml.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class ClientDaoImpl implements ClientDao {

    private final EntityManager entityManager;

    @Autowired
    public ClientDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(ClientEntity client) {
        entityManager.persist(client);
    }
}

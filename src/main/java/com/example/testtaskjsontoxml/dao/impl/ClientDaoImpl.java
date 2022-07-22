package com.example.testtaskjsontoxml.dao.impl;

import com.example.testtaskjsontoxml.dao.ClientDao;
import com.example.testtaskjsontoxml.entity.ClientEntity;
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

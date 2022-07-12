package com.example.test_task_json_to_xml.dao.impl;

import com.example.test_task_json_to_xml.dao.DocumentDao;
import com.example.test_task_json_to_xml.entity.DocumentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager entityManager;

    @Autowired
    public DocumentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(DocumentEntity document){
        entityManager.persist(document);
    }
}

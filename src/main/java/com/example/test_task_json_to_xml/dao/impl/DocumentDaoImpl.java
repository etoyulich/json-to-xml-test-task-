package com.example.test_task_json_to_xml.dao.impl;

import com.example.test_task_json_to_xml.dao.DocumentDao;
import com.example.test_task_json_to_xml.entity.DocumentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    public DocumentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
       // this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(DocumentEntity document){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(document);
        transaction.commit();
        session.close();
    }
}

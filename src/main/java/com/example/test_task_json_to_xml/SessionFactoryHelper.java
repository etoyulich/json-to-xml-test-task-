//package com.example.test_task_json_to_xml;
//
//import com.example.test_task_json_to_xml.entity.DocumentEntity;
//import com.example.test_task_json_to_xml.entity.UserEntity;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class SessionFactoryHelper {
//    private static final SessionFactory sessionFactory;
//
//    static {
//        try {
//            Configuration config = new Configuration();
//            config.addAnnotatedClass(UserEntity.class);
//            config.addAnnotatedClass(DocumentEntity.class);
//            sessionFactory = config.configure().buildSessionFactory();
//        } catch (Throwable e) {
//            System.err.println("Error in creating SessionFactory object."
//                    + e.getMessage());
//            throw new ExceptionInInitializerError(e);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//}
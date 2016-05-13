package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSession {
    private static Configuration config;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private Session session;
    
    public HibernateSession(){
       
    }
    
    public static synchronized SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            config = new Configuration();
            config.configure("hibernate.cfg.xml");
            serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(config.getProperties()).build();
            sessionFactory = config
                                .addAnnotatedClass(com.database.Message.class)
                                .addAnnotatedClass(com.database.Users.class)
                                .addAnnotatedClass(com.database.Student.class)
                                .addAnnotatedClass(com.database.Company.class)
                                .addAnnotatedClass(com.database.Currency.class)
                                .addAnnotatedClass(com.database.AnnouncementPacket.class)
                                .addAnnotatedClass(com.database.Announcement.class)
                                .addAnnotatedClass(com.database.AnnouncementState.class)
                                .addAnnotatedClass(com.database.AnnouncementType.class)
                                .addAnnotatedClass(com.database.BankAccountInfo.class)
                                .addAnnotatedClass(com.database.DonationAcceptUnit.class)
                                .addAnnotatedClass(com.database.Donation.class)
                                .buildSessionFactory(serviceRegistry);
        }
        
        return sessionFactory;
    }
    
    
}

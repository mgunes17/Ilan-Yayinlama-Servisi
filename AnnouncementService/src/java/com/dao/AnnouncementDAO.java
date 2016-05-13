package com.dao;

import com.database.Announcement;
import com.database.AnnouncementType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnnouncementDAO {
    private Session session;
    
    public List<Announcement> getAllAnnouncements(){
        session = HibernateSession.getSessionFactory().openSession();
        List<Announcement> allAnnouncements = null;
        
        try{
            Query query = (Query)session.createQuery("from Announcement");
             allAnnouncements = query.list();
        }
        catch(Exception e){
            
        }
        finally{
            session.close();
        }
        
        return allAnnouncements;
    }
    
    public void createAnnouncement(Announcement announcement){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(announcement);
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
        }
    }
    
    public List<AnnouncementType> getAnnouncementTypes(){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        List<AnnouncementType> announcementTypes = null;
                
        try{
            tx = session.beginTransaction();
            Query query = (Query)session.createQuery("from AnnouncementType");
            announcementTypes = query.list();
        }
        catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        
        return announcementTypes;
    }
    
    public List<Announcement> getMyAnnouncements(String userName){
        List<Announcement> myAnnouncementList = null;
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            Query query = (Query)session.
                    createQuery("from Announcement where owner_company = '"+userName+"'");
            
            myAnnouncementList = query.list();
        }
        catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        
        return myAnnouncementList;
    }
}

package com.dao;

import com.database.AnnouncementState;
import org.hibernate.Query;
import org.hibernate.Session;

public class AnnouncementStateDAO {
    private Session session;
    
    public AnnouncementState getState(int id){
        session = HibernateSession.getSessionFactory().openSession();
        AnnouncementState type = null;
        
        try{
            Query query = (Query) session.createQuery
                ("from AnnouncementState where id = "+id);
            
            type = (AnnouncementState) query.uniqueResult();
        }
        catch(Exception e){
            System.err.println(e);
        }
        finally{
            session.close();
        }
        
        return type;
    }
}

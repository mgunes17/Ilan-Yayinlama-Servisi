package com.dao;

import com.database.AnnouncementType;
import org.hibernate.Query;
import org.hibernate.Session;

public class AnnouncementTypeDAO {
    private Session session;
    
    public AnnouncementType getType(int id){
        session = HibernateSession.getSessionFactory().openSession();
        AnnouncementType type = null;
        
        try{
            Query query = (Query) session.createQuery
                ("from AnnouncementType where id = "+id);
            
            type = (AnnouncementType) query.uniqueResult();
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

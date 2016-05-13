package com.dao;

import com.database.Message;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MessageDAO {
    private Session session;
    private List<Message> messages;
    
    public List<Message> readMessages(){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        List<Message> messages = null;
                
        try{
            tx = session.beginTransaction();
            Query query = (Query) session.createQuery("from Message");
            messages = query.list();
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
             //redirect
        }
        finally{
            session.close();
        }
        
        return messages;
    }
    
    public void sendMessage(Message message){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(message);
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            //sonra hata sayfasına yönlendir
        }
        finally{
            session.close();
        }
        
    }
}

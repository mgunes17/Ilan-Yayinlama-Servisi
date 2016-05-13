
package com.dao;

import com.database.AnnouncementPacket;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnnouncementPacketDAO {
    private Session session;
    private List<AnnouncementPacket> packets = new ArrayList<>();
    
    public AnnouncementPacket getPacket(int id){
        session = HibernateSession.getSessionFactory().openSession();
        AnnouncementPacket packet = null;
        
        try{
            Query query = (Query) session.createQuery
                ("from AnnouncementPacket where packetId = "+id);
            
            packet = (AnnouncementPacket) query.uniqueResult();
        }
        catch(Exception e){
            System.err.println(e);
        }
        finally{
            session.close();
        }
        
        return packet;
    }
    
    public List<AnnouncementPacket> displayPackets(){
        session = HibernateSession.getSessionFactory().openSession();
        try{
            Query query = (Query) session.createQuery("from AnnouncementPacket");
            packets = query.list();
        }
        catch(Exception e){
            System.err.println(e);
        }
        finally{
            session.close();
        }
        
        return packets;
    }
    
    public void deletePacket(int id){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            Query q = session.createQuery("delete AnnouncementPacket where packetId ="+id);
            q.executeUpdate();
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            System.err.println(e);
        }
        finally{
            session.close();
        }
          
    }
    
    public void savePacket(AnnouncementPacket packet){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(packet);
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
        }
        finally{
            session.close();
        }
    }
}

package com.dao;

import com.database.BankAccountInfo;
import com.database.DonationAcceptUnit;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DonationAcceptUnitDAO {
    private Session session;
    
    public void saveUnit(DonationAcceptUnit dau){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(dau);
            tx.commit();
            //kayıt başarılı göster
        }
        catch(Exception e){
            tx.rollback();
        }
        finally{
            session.close();
        }
    }
    
    public List<DonationAcceptUnit> readAllUnits(){
        session = HibernateSession.getSessionFactory().openSession();
        List<DonationAcceptUnit> unit = null;
        
        try{
            Query query = (Query) session.createQuery("from DonationAcceptUnit");
            unit = query.list();
        }
        catch(Exception e){
            
        }
        finally{
            session.close();
        }
        
        return unit;
    }
    
    public void saveBankAccount(BankAccountInfo bai){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(bai);
            tx.commit();
            //kayıt başarılı göster
        }
        catch(Exception e){
            tx.rollback();
        }
        finally{
            session.close();
        }
    }
}

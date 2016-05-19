package com.dao;

import com.database.BankAccountInfo;
import com.database.DauUser;
import com.database.DonationAcceptUnit;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DonationAcceptUnitDAO {
    private Session session;
    
    public DonationAcceptUnit getUnit(int id){
        session = HibernateSession.getSessionFactory().openSession();
        DonationAcceptUnit dau = null;
        
        try{
            Query query = (Query) session.createQuery
                ("from DonationAcceptUnit where id = "+id);
            
            dau = (DonationAcceptUnit) query.uniqueResult();
        }
        catch(Exception e){
            System.err.println(e);
        }
        finally{
            session.close();
        }
        
        return dau;
    }
    
    public boolean deleteUnit(int unitId){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
           
            //session.delete(dau);
          
            
            Query query = (Query) session.createQuery
                    ("delete DonationAcceptUnit where id="+unitId);
            query.executeUpdate();
        }
        catch(Exception e){
            tx.rollback();
            return false;
        }
        finally{
            session.close();
        }
        
        return true;
    }
    
    public boolean saveBankAccount(BankAccountInfo bai){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(bai);
            tx.commit();
            
        }
        catch(Exception e){
            tx.rollback();
            return false;
        }
        finally{
            session.close();
        }
        
        return true;
    }
    
    public boolean saveDauUser(DauUser user){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            //kayıt başarılı göster
        }
        catch(Exception e){
            tx.rollback();
            return false;
        }
        finally{
            session.close();
        }
        
        return true;
    }
    
    public boolean saveUnit(DonationAcceptUnit dau){
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
            return false;
        }
        finally{
            session.close();
        }
        
        return true;
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
    
}

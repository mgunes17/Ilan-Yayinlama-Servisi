package com.dao;

import com.database.Company;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyDAO {
     private Session session;
    
    public void saveCompany(Company company){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(company);
            tx.commit();
            //kayıt başarılı göster
        }
        catch(Exception e){
            tx.rollback();
            //hata sayfasına yönlendir
        }
        finally{
            session.close();
        }
    }
}

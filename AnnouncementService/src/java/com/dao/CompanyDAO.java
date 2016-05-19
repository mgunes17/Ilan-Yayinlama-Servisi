package com.dao;

import com.database.Company;
import org.hibernate.Query;
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
    
    public Company getCompany(String userName){
        session = HibernateSession.getSessionFactory().openSession();
        Company company = null;
        
        try{
            Query query = (Query) session.createQuery
                ("from Company where id = '"+userName+"'");
            
            company = (Company) query.uniqueResult();
        }
        catch(Exception e){
            System.err.println(e);
        }
        finally{
            session.close();
        }
        
        return company;
    }
}

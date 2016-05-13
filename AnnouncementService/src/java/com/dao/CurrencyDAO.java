package com.dao;

import com.database.Currency;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CurrencyDAO {
    private Session session;
    
    public List<Currency> readCurrency(){
        List <Currency> currency = null;
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            Query query = (Query) session.createQuery("from Currency");
            currency = query.list();
            tx.commit();
            //kayıt başarılı göster
        }
        catch(Exception e){
            e.printStackTrace();
            tx.rollback();
            //hata sayfasına yönlendir
        }
        finally{
            session.close();
        }
        
        return currency;
    }
}

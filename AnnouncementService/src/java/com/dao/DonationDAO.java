package com.dao;

import com.database.Company;
import com.database.Donation;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DonationDAO {
    private Session session;
    
    public DonationDAO(){
        
    }
    
    public List<Donation> waitForApprovalDonations(String userName){
        session = HibernateSession.getSessionFactory().openSession();
        List<Donation> donations = null;
        
        try{
            Query query = (Query)session.createQuery(
                    "from Donation where donationAcceptUnitUsername= 'userName'"
                            + " and approved="+false);
            donations = query.list();
        }
        catch(Exception e){
            
        }
        finally{
            session.close();
        }
        
        return donations;
    }
    
    public void saveDonation(Donation donation){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(donation);
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

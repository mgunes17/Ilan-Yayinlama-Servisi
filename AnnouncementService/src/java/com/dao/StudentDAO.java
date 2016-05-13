package com.dao;

import com.database.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
    private Session session;
    
    public void saveStudent(Student student){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(student);
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

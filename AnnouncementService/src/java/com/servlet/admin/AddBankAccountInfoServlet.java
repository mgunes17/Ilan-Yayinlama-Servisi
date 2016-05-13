package com.servlet.admin;

import com.database.BankAccountInfo;
import com.database.DonationAcceptUnit;
import com.database.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "AddBankAccountInfoServlet", urlPatterns = {"/addbankaccountinfoservlet"})
public class AddBankAccountInfoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Configuration cfg=new Configuration();  
        cfg.addAnnotatedClass(BankAccountInfo.class);
        cfg.configure("hibernate.cfg.xml"); 
        
        SessionFactory factory=cfg.buildSessionFactory(); 
        Session session=factory.openSession();   
        
        Transaction t=session.beginTransaction();
        
        BankAccountInfo bai = new BankAccountInfo();
       /* bai.setBankAccountNumber(Integer.parseInt(request.getParameter("accountnumber")));
        bai.setBankName(request.getParameter("bankname"));
        bai.setBranchBankName(request.getParameter("nameofbranch"));
        bai.setIban(request.getParameter("iban"));
        bai.setOwnerUnitName(request.getParameter("unitname"));
        bai.setCurrency(request.getParameter("currency"));*/
    }


}

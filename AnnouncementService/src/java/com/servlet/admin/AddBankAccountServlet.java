package com.servlet.admin;

import com.dao.CurrencyDAO;
import com.dao.DonationAcceptUnitDAO;
import com.database.BankAccountInfo;
import com.database.Currency;
import com.database.DonationAcceptUnit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddBankAccountServlet", urlPatterns = {"/addbankaccountservlet"})
public class AddBankAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        session.setAttribute("vakifolusturuldu", 0);
        session.setAttribute("kullanicieklendi", 0);
        
        //Banka hesap bilgisi özelliklerini oku
        BankAccountInfo bai  = new BankAccountInfo();
        bai.setBankAccountNumber(request.getParameter("account_number"));
        bai.setBankName(request.getParameter("bank_name"));
        bai.setBranchBankName(request.getParameter("name_of_branch"));
        
        Currency currency = new CurrencyDAO().getCurrency(
                Integer.parseInt(request.getParameter("currency")));
        bai.setCurrency(currency);
        bai.setIban(request.getParameter("iban"));

        bai.setUnit((DonationAcceptUnit) session.getAttribute("dauUser"));
        
          
        if(session.getAttribute("dauUser") == null){
            session.setAttribute("hesapeklendi", 2);
        }
        else if(new DonationAcceptUnitDAO().saveBankAccount(bai)){
            session.setAttribute("hesapeklendi", 1);
            session.setAttribute("vakifolusturuldu", 0);
        }
        else{
            session.setAttribute("hesapeklendi", 2);
        }
        
        response.sendRedirect("admin/vakif-olustur.jsp");
    }

}

package com.servlet.admin;

import com.dao.DonationAcceptUnitDAO;
import com.database.BankAccountInfo;
import com.database.DonationAcceptUnit;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateDonationUnitServlet", urlPatterns = {"/createdonationunitservlet"})
public class CreateDonationUnitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //okunan form bilgisi Türkçe karaktere uygun hale getirildi
        request.setCharacterEncoding("UTF-8");
        
        //Bağış kabul birimi özelliklerini oku
        DonationAcceptUnit dau = new DonationAcceptUnit();
        dau.setUnitName(request.getParameter("unit_name"));
        dau.setUserName(request.getParameter("user_name"));
        dau.setPassword(request.getParameter("password"));
        dau.setUserTypeNo(1);
        dau.setBalance(0);
        
        //Banka hesap bilgisi özelliklerini oku
        BankAccountInfo bai  = new BankAccountInfo();
        bai.setBankAccountNumber(Integer.parseInt(request.getParameter("account_number")));
        bai.setBankName(request.getParameter("bank_name"));
        bai.setBranchBankName(request.getParameter("name_of_branch"));
        bai.setCurrency(Integer.parseInt(request.getParameter("currency")));
        bai.setIban(request.getParameter("iban"));
        bai.setOwnerUnitName(dau.getUnitName());
        
        new DonationAcceptUnitDAO().saveUnit(dau);
        new DonationAcceptUnitDAO().saveBankAccount(bai);
        
        response.sendRedirect("admin/success.jsp");
    }

}

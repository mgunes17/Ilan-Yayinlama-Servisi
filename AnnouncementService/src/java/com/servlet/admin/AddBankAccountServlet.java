package com.servlet.admin;

import com.dao.DonationAcceptUnitDAO;
import com.database.BankAccountInfo;
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
        
        //Banka hesap bilgisi özelliklerini oku
        BankAccountInfo bai  = new BankAccountInfo();
        bai.setBankAccountNumber(Integer.parseInt(request.getParameter("account_number")));
        bai.setBankName(request.getParameter("bank_name"));
        bai.setBranchBankName(request.getParameter("name_of_branch"));
        bai.setCurrency(Integer.parseInt(request.getParameter("currency")));
        bai.setIban(request.getParameter("iban"));
        
        //duzenlenecek
        //bai.setOwnerUnitName(dau.getUnitName());
        
        HttpSession session = request.getSession();
        session.setAttribute("hesapeklendi", 1);
        new DonationAcceptUnitDAO().saveBankAccount(bai);
        
        response.sendRedirect("newdonationacceptunit");
    }

}

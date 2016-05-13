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
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        //Bağış kabul birimi özelliklerini oku
        DonationAcceptUnit dau = new DonationAcceptUnit();
        dau.setUnitName(request.getParameter("unit_name"));
        dau.setBalance(0);
        
        
        
        if(new DonationAcceptUnitDAO().saveUnit(dau)){
            session.setAttribute("vakifolusturuldu", 1);
            session.setAttribute("dauUser", dau);
        }
        else{
            session.setAttribute("vakifolusturuldu", 2);
        }
        
        response.sendRedirect("admin/vakif-olustur.jsp");
    }

}

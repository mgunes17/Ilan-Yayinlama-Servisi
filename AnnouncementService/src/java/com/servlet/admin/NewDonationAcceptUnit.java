package com.servlet.admin;

import com.dao.CurrencyDAO;
import com.database.Currency;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "NewDonationAcceptUnit", urlPatterns = {"/newdonationacceptunit"})
public class NewDonationAcceptUnit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Currency> currency = new CurrencyDAO().readCurrency();
        HttpSession session = request.getSession();
        session.setAttribute("curr", currency);
        response.sendRedirect("admin/vakif-olustur.jsp");
        
        
    }

}

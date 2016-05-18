/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.admin;

import com.dao.DonationAcceptUnitDAO;
import com.database.DauUser;
import com.database.DonationAcceptUnit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author must
 */
@WebServlet(name = "AddDauUser", urlPatterns = {"/adddauuserservlet"})
public class AddDauUserServlet extends HttpServlet {

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
        
        DauUser dauUser = new DauUser();
        dauUser.setUserTypeNo(1);
        dauUser.setUserName(request.getParameter("user_name"));
        dauUser.setPassword(request.getParameter("password"));
        dauUser.setUnit((DonationAcceptUnit) session.getAttribute("dauUser"));
        
        if(session.getAttribute("dauUser") == null){
            session.setAttribute("kullanicieklendi", 2);
        }
        else if(new DonationAcceptUnitDAO().saveDauUser(dauUser)){
            session.setAttribute("kullanicieklendi", 1);
            session.setAttribute("vakifolusturuldu", 0);
        }
        else{
            session.setAttribute("kullanicieklendi", 2);
        }
        
        response.sendRedirect("admin/vakif-olustur.jsp");
        
    }

}

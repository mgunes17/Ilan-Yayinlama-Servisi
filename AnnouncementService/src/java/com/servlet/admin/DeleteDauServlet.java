package com.servlet.admin;

import com.dao.DonationAcceptUnitDAO;
import com.database.DonationAcceptUnit;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DeleteDauServlet", urlPatterns = {"/deletedauservlet"})
public class DeleteDauServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int unitId = Integer.parseInt(request.getParameter("unitId"));
        //Object dau = session.getAttribute(dauString);
        
        if(new DonationAcceptUnitDAO().deleteUnit(unitId)){
            session.setAttribute("dausilindi", 1);
        }
        else{
            session.setAttribute("dausilindi", 2);
        }
        
        response.sendRedirect("displaydauservlet");
    }

}

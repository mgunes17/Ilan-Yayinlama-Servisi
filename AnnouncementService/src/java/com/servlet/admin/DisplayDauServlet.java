package com.servlet.admin;

import com.dao.DonationAcceptUnitDAO;
import com.database.DonationAcceptUnit;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DisplayDauServlet", urlPatterns = {"/displaydauservlet"})
public class DisplayDauServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<DonationAcceptUnit> dauList;
        dauList = new DonationAcceptUnitDAO().readAllUnits();
        
        session.setAttribute("dauList", dauList);
        response.sendRedirect("admin/vakiflari-duzenle.jsp");
    }

}

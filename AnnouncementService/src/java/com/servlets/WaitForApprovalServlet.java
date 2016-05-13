package com.servlets;

import com.dao.DonationDAO;
import com.database.Donation;
import com.database.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "WaitForApproval", urlPatterns = {"/waitforapprovalservlet"})
public class WaitForApprovalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        List<Donation> donations = new DonationDAO().
                waitForApprovalDonations(user.getUserName());
        
        response.sendRedirect("dau/waitforapproval.jsp");
    }

}

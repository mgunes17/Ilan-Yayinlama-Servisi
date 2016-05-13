package com.servlets;

import com.dao.CompanyDAO;
import com.database.Company;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CompanySaveServlet", urlPatterns = {"/companysaveservlet"})
public class CompanySaveServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Company company = new Company(
            request.getParameter("mersis_no"),
            request.getParameter("company_name"),
            request.getParameter("location"),
            request.getParameter("user_name"),
            request.getParameter("password")
        );
        
        new CompanyDAO().saveCompany(company);
        response.sendRedirect("index.jsp");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.dao.AnnouncementDAO;
import com.database.Announcement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "AllAnnouncementsServlet", urlPatterns = {"/listallannouncementsservlet"})
public class ListAllAnnouncementsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Announcement> allAnnouncements = new AnnouncementDAO().getAllAnnouncements();
        
        HttpSession session = request.getSession();
        session.setAttribute("announcements", allAnnouncements);
        response.sendRedirect("company/allannouncements.jsp");
    }

}

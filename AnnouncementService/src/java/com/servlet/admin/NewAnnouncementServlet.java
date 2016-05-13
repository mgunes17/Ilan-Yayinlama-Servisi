/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.admin;

import com.dao.AnnouncementDAO;
import com.database.Announcement;
import com.database.Users;
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
@WebServlet(name = "NewAnnouncementServlet", urlPatterns = {"/newannouncementservlet"})
public class NewAnnouncementServlet extends HttpServlet {

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
        
        Users user = (Users) session.getAttribute("user");
        Announcement announcement = new Announcement();
        announcement.setTitle(request.getParameter("title"));
        announcement.setBrief(request.getParameter("brief"));
        announcement.setContent(request.getParameter("content"));
        announcement.setOwnerCompany(user.getUserName());
        announcement.setOwnerPacket(0); //yeni oluşturulan ilanın paketi de olabilir
        announcement.setState(1); //yeni oluşturulduğu için pasif. olmaya da bilir
        
        //tip jstl ile okunacak
        announcement.setAnnouncementType(Integer.parseInt(request.getParameter("type")));
        
        new AnnouncementDAO().createAnnouncement(announcement);
        
        response.sendRedirect("newannouncementcreated.jsp");
    }

}

package com.servlet.company;

import com.dao.AnnouncementDAO;
import com.database.Announcement;
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

@WebServlet(name = "ListMyAnnouncementServlet", urlPatterns = {"/listmyannouncementservlet"})
public class ListMyAnnouncementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //sadece ona ait bilgileri getirmek icin oturum bilgisi kullan
        //şimdilik şirket id elle ver
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        List<Announcement> myAnnouncements = new AnnouncementDAO().
                getMyAnnouncements(user.getUserName());
        
        session.setAttribute("announcement", myAnnouncements);
        response.sendRedirect("company/myannouncements.jsp");
    }

}

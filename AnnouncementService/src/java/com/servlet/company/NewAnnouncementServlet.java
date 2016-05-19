package com.servlet.company;

import com.dao.AnnouncementDAO;
import com.dao.AnnouncementStateDAO;
import com.dao.AnnouncementTypeDAO;
import com.dao.CompanyDAO;
import com.database.Announcement;
import com.database.AnnouncementState;
import com.database.AnnouncementType;
import com.database.Company;
import com.database.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        AnnouncementType annType = new AnnouncementTypeDAO().getType(1);
        Company company = new CompanyDAO().getCompany(user.getUserName());
        AnnouncementState state = new AnnouncementStateDAO().getState(1);
        
        announcement.setTitle(request.getParameter("title"));
        announcement.setBrief(request.getParameter("brief"));
        announcement.setContent(request.getParameter("content"));
        announcement.setOwnerCompany(company);
        //announcement.setOwnerPacket(); //yeni oluşturulan ilanın paketi de olabilir
        announcement.setState(state); //yeni oluşturulduğu için pasif. olmaya da bilir
        
        //tip jstl ile okunacak
        announcement.setAnnouncementType(Integer.parseInt(request.getParameter("type")));
        
        new AnnouncementDAO().createAnnouncement(announcement);
        
        response.sendRedirect("company/ilan-olustur.jsp");
    }

}


package com.servlet.admin;

import com.dao.AnnouncementDAO;
import com.database.AnnouncementType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "NewAnnouncementControlServlet", urlPatterns = {"/newannouncementcontrolservlet"})
public class NewAnnouncementControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<AnnouncementType> announcementTypes = new AnnouncementDAO().getAnnouncementTypes();
        HttpSession session = request.getSession();
        session.setAttribute("annType", announcementTypes);
        response.sendRedirect("company/newannouncement.jsp");
    }

}

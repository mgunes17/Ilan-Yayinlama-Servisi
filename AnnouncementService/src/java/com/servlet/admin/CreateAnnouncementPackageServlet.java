package com.servlet.admin;

import com.dao.AnnouncementPacketDAO;
import com.database.AnnouncementPacket;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CreateAnnouncementPackageServlet", urlPatterns = {"/createannouncementpackageservlet"})
public class CreateAnnouncementPackageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String date = request.getParameter("last_date_used");
        Timestamp expired = Timestamp.valueOf(date+":00.0");
        
        System.out.println(expired);
        
        AnnouncementPacket packet = new AnnouncementPacket();
        packet.setTitle(request.getParameter("packet_name"));
        packet.setDonateAcceptUnit(request.getParameter("unit"));
        packet.setActiveTime(Integer.parseInt(request.getParameter("activate_date")));
        packet.setLastDateUsed(expired);
        packet.setAnnouncementCount(Integer.parseInt(
                request.getParameter("announcement_number")));
        packet.setCurrency(Integer.parseInt(request.getParameter("currency")));
        packet.setPrice(Integer.parseInt(request.getParameter("price")));
        packet.setCondition(request.getParameter("condition"));
        
        new AnnouncementPacketDAO().savePacket(packet);
        
        HttpSession session = request.getSession();
        session.setAttribute("olusturuldu", 1);
        response.sendRedirect("admin/createannouncementpacket.jsp");
    }

}

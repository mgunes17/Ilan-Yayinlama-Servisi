package com.servlet.admin;

import com.dao.AnnouncementPacketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteAnnouncementPacket", urlPatterns = {"/deleteannouncementpacket"})
public class DeleteAnnouncementPacket extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int packetId = Integer.parseInt(request.getParameter("packetId"));
        new AnnouncementPacketDAO().deletePacket(packetId);
        response.sendRedirect("displaypackets");
    }

}

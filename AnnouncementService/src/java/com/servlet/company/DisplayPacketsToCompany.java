package com.servlet.company;

import com.dao.AnnouncementPacketDAO;
import com.database.AnnouncementPacket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DisplayPacketsToCompany", urlPatterns = {"/displaypacketstocompany"})
public class DisplayPacketsToCompany extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                List<AnnouncementPacket> packets = new AnnouncementPacketDAO()
                .displayPackets();
        
        HttpSession session = request.getSession();
        session.setAttribute("packets", packets);
        response.sendRedirect("company/announcementpackets.jsp");
    }

}

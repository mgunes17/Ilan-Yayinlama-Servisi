package com.servlet.admin;

import com.dao.AnnouncementPacketDAO;
import com.dao.CurrencyDAO;
import com.dao.DonationAcceptUnitDAO;
import com.database.AnnouncementPacket;
import com.database.Currency;
import com.database.DonationAcceptUnit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UpdatePacket", urlPatterns = {"/updatepacket"})
public class UpdatePacket extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int packetId = Integer.parseInt(request.getParameter("packetId"));
        AnnouncementPacket packet = new AnnouncementPacketDAO().getPacket(packetId);
        
        HttpSession session = request.getSession();
        List<Currency> currency = new CurrencyDAO().readCurrency();
        List<DonationAcceptUnit> unit = new DonationAcceptUnitDAO().readAllUnits();
        
        session.setAttribute("curr", currency);
        session.setAttribute("dau", unit);
        session.setAttribute("packet", packet);
        response.sendRedirect("admin/updatepacket.jsp");
    }

}

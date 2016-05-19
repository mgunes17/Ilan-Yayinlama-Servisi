package com.servlets;

import com.dao.AnnouncementPacketDAO;
import com.dao.DonationDAO;
import com.database.AnnouncementPacket;
import com.database.Donation;
import com.database.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DonationRequest", urlPatterns = {"/donationrequest"})
public class DonationRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        Donation donation = new Donation();
        
        int packetId = Integer.parseInt(request.getParameter("packetId"));
        String companyUsername = user.getUserName();
        AnnouncementPacket packet = new AnnouncementPacketDAO().getPacket(packetId);
       
        donation.setCompanyUsername(companyUsername);
        donation.setPacketId(packetId);
        donation.setDonationAcceptUnitUsername(packet.getDonateAcceptUnit().getUnitName());
        
        new DonationDAO().saveDonation(donation);
        
        response.sendRedirect("company/donationrequest.jsp");
    }

}

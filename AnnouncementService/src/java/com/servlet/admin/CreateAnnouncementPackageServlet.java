package com.servlet.admin;

import com.dao.AnnouncementPacketDAO;
import com.dao.CurrencyDAO;
import com.dao.DonationAcceptUnitDAO;
import com.database.AnnouncementPacket;
import com.database.Currency;
import com.database.DonationAcceptUnit;
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
        Currency curr = new CurrencyDAO().getCurrency(
                Integer.parseInt(request.getParameter("currency")));
        
        DonationAcceptUnit dau = new DonationAcceptUnitDAO().getUnit(
                Integer.parseInt(request.getParameter("unit")));

        
        packet.setTitle(request.getParameter("packet_name"));
        packet.setDonateAcceptUnit(dau);
        packet.setActiveTime(Integer.parseInt(request.getParameter("activate_date")));
        packet.setLastDateUsed(expired);
        packet.setAnnouncementCount(Integer.parseInt(
                request.getParameter("announcement_number")));
        packet.setCurrency(curr);
        packet.setPrice(Integer.parseInt(request.getParameter("price")));
        packet.setCondition(request.getParameter("condition"));
        
        HttpSession session = request.getSession();
        
        if(new AnnouncementPacketDAO().savePacket(packet)){
            session.setAttribute("olusturuldu", 1);
        }
        else{
            session.setAttribute("olusturuldu", 2);
        }
        
        session.setAttribute("olusturuldu", 1);
        response.sendRedirect("admin/paket-olustur.jsp");
    }

}

package com.servlets;

import com.dao.MessageDAO;
import com.database.Message;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "SendMessageServlet", urlPatterns = {"/sendmessageservlet"})
public class SendMessageServlet extends HttpServlet {
    Message message;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        message = new Message();
        request.setCharacterEncoding("UTF-8");
        readRequest(request);

        new MessageDAO().sendMessage(message);
        
        HttpSession httpSession = request.getSession();
        
        httpSession.setAttribute("gonderildi", 1);
        response.sendRedirect("iletisim.jsp");
    }

    private void readRequest(HttpServletRequest request){
        message.setMessageTitle(request.getParameter("title"));
        message.setMessageBody(request.getParameter("message"));
        message.setMailAddress(request.getParameter("mail"));
        
        message.setIPAddress(request.getRemoteAddr());
        message.setDateTime(Calendar.getInstance());
    }
}

package com.servlets;

import com.database.UserType;
import com.database.Users;
import java.io.IOException;
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

@WebServlet("/logincontrolservlet")
public class LoginControlServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Configuration cfg=new Configuration();  
        cfg.addAnnotatedClass(Users.class);
        cfg.addAnnotatedClass(UserType.class);
        cfg.configure("hibernate.cfg.xml"); 
        
        SessionFactory factory=cfg.buildSessionFactory(); 
        Session session=factory.openSession();   
        
        Transaction t=session.beginTransaction();
        HttpSession httpSession = request.getSession();
        Users user = (Users) session.get(Users.class, username); 
        
        if(user != null){
            if(user.getPassword().equals(password)){
                UserType userType = (UserType) session.get(UserType.class, user.getUserTypeNo());
                
                httpSession.setAttribute("user",user);
                httpSession.setMaxInactiveInterval(300);
                response.sendRedirect(userType.getMain_page());
            }
            else{
                httpSession.setAttribute("hata",1);
                response.sendRedirect("giris-yap.jsp");
            }
        }
        else{
            httpSession.setAttribute("hata",1);
            response.sendRedirect("giris-yap.jsp");
        }
       
        t.commit();//transaction is committed  
        session.close();  
      
    }
    
}
<%-- 
    Document   : deneme
    Created on : 28.Nis.2016, 01:16:26
    Author     : must
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
         
        </head>
        <body>
        <% 
        Timestamp start = Timestamp.valueOf("2016-04-28 17:39:10.0");
        out.println(start);
        
        Timestamp finish = Timestamp.valueOf("2016-04-28 17:40:10.0");
        out.println(finish);
        
        out.println(finish.getTime()-start.getTime());
        %>
        
        <input type="date" name="deneme"/>
        
        <% out.println(request.getParameter("packetId")); %>
        </body>
    </html>





</html>
<%-- 
    Document   : company
    Created on : 14.Nis.2016, 01:10:11
    Author     : must
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.database.Users" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="html/head.html"/>
    <title>Anasayfa</title>
</head>
<body>  
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="html/header.html"/>
        </div>
        <div class="row">
            <h1>Hoşgeldiniz ${user.userName}</h1>
        </div>
        <div class="row">
            <div class="col-md-4">
                <jsp:include page="html/menu.html"/>
            </div>
        </div>
        <div class="row">
            <jsp:include page="../html/footer.html"/>
        </div>
    </div>
               
</body>
</html>

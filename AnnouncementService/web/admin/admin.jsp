<%-- 
    Document   : admin
    Created on : 20.Mar.2016, 20:50:42
    Author     : must
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <jsp:include page="html/head.html"/>
        <title>Yönetici Anasayfa</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="html/header.html"/>
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

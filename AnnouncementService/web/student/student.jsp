<%-- 
    Document   : student.jsp
    Created on : 22.Nis.2016, 13:31:06
    Author     : must
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Öğrenci</title>
</head>
<body>
    <jsp:include page="html/logout.html"></jsp:include>
    <%String userName = (String)session.getAttribute("user");%>
    <h1>Hoşgeldiniz <%=userName%></h1>
    <a href="listallannouncementsservlet">Tüm ilanları görüntüle</a>
    <a href="#">İlan Ara</a></br>
    <a href="#">Başvurularım</a></br>
    <a href="#">Profilimi Düzenle</a></br>
    <a href="#">CV mi düzenle</a></br>
</body>
</html>

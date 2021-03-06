<%-- 
    Document   : AllAnnouncements
    Created on : 23.Nis.2016, 23:54:42
    Author     : must
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tüm İlanlar</title>
</head>
<body>
    <jsp:include page="html/logout.html"></jsp:include>
    <h4><a href="directcompanymainpageservlet">Anasayfa</a></h4>
    <h1>Tüm ilanlar</h1>
     <table border="0">
        <thead>
            <tr>
                <th>İlan No</th>
                <th>Başlık</th>
                <th>Ön Açıklama</th>
                <th>Durum</th>
                <th>Başvuru Sayısı</th>
            </tr>
        </thead>
        <tbody>
            <form action="announcementdetailservlet" method="post">
                <c:forEach var="item" items="${announcements}">
                    <tr>
                        <td><input type="radio" name="announcement" value="${item.id}"></td>
                        <td>${item.id}</td>
                        <td>${item.title}</td>
                        <td>${item.brief}</td>
                        <td>${item.state}</td>
                        <td>${item.numberOfPageViews}</td>
                        <td></td>
                    </tr>
                </c:forEach>
                <input type="submit" value="Detaya Git"/>
            </form>
        </tbody>
    </table>
</body>
</html>

<%-- 
    Document   : displaydau
    Created on : 01.May.2016, 16:11:35
    Author     : must
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="html/head.html"/>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>BKB Listesi</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="html/header.html"/>
        </div>
        <div class="row">
            <div class="col-md-3"><jsp:include page="html/menu.html"/></div>
            <div class="col-md-9">
                <c:choose>
                    <c:when test="${dausilindi eq 1}">
                       <div id="alert" class="alert alert-success">
                            <strong>Başarılı!</strong> Vakıf silindi
                        </div>
                    </c:when>
                    <c:when test="${dausilindi eq 2}">
                       <div id="alert" class="alert alert-danger">
                            <strong>Başarısız!</strong> Vakıf silinemedi
                        </div>
                    </c:when>
                </c:choose>
                <h3>Tanımlı Bağış Kabul Edebilecek Birimler</h3>
                <table class="displayTable" id="table" border="1">
                    <thead>
                        <tr>
                            <th>Birim Adı</th>
                            <th>Bakiye</th>
                            <th>Oluşturulma Tarihi</th>
                            <th>Tanımlı Kullanıcı Sayısı</th>
                            <th>Tanımlı Hesap Sayısı</th>
                            <th>İşlemler</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="item" items="${dauList}">
                            <tr>
                                <td>${item.unitName}</td>
                                <td>${item.balance}</td>
                                <td><%--Tarih--%></td>
                                <td><%--say--%></td>
                                <td><%--say--%></td>
                                <td>
                                    <form method="post">
                                        <input type="hidden" name="unitId" value="${item.id}" />
                                        <input type="submit" value="Detaylar" formaction="../">
                                        <input 
                                            onclick="return confirm('Paketi silmek istediğinize emin misiniz?')""
                                            type="submit" 
                                            value="Sil" 
                                            formaction="../deletedauservlet">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <a href="../newdonationacceptunit">Yeni Birim Ekle</a>
            </div>
                
            </div>
        </div>
    </div>

    <jsp:include page="../html/footer.html"></jsp:include> 
    
</body>
</html>
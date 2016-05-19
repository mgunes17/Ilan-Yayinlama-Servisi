<%-- 
    Document   : newannouncement
    Created on : 22.Nis.2016, 13:55:41
    Author     : must
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="html/head.html"/>
    <title>İlan Oluştur</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="html/header.html"/>
        </div>
        <div class="row">
            <div class="col-md-4"><jsp:include page="html/menu.html"/></div>
            <div class="col-md-8">
                <div class="text-centers">
                    <c:choose>
                        <c:when test="${olusturuldu eq 1}">
                           <div class="alert alert-success">
                                 <strong>Başarılı!</strong>İlan başarıyla oluşturuldu.
                            </div>
                        </c:when>
                        <c:when test="${olusturuldu eq 2}">
                           <div class="alert alert-danger">
                                 <strong>Başarısız!</strong>İlan oluşturulamadı.
                            </div>
                        </c:when>
                    </c:choose>
                
                    <h1>İlanınızı Oluşturun</h1>
                    <form method="POST" action="../newannouncementservlet">
                        <table class="table" id="formTable">
                        <tbody>
                        <tr>
                            <td>İlan Başlığı</td>
                            <td><input type="text" name="title"/></td>
                        </tr>
                        <tr>
                            <td>Kısa Açıklama</td>
                            <td><input type="text" name="brief"/></td>
                        </tr>
                        <tr>
                            <td>İlan detayları</td>
                            <td><textarea name="content" class="form-control" rows="5" id="comment"></textarea></td>
                        </tr>
                        <tr>
                            <td>İlan tipi</td>
                            <td>
                                <select name="type">
                                    <c:forEach var="item" items="${annType}">
                                        <option value="${item.id}">
                                            <c:out value="${item.title}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                                
                        <tr><td colspan="2">
                            <button type="submit" class="btn btn-default">
                                Oluştur
                            </button>
                        </td></tr>
                        </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
     
    <jsp:include page="../html/footer.html"></jsp:include> 
    
</body>
</html>

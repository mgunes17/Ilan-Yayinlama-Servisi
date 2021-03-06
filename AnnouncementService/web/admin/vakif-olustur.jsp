<%-- 
    Document   : createdonationacceptunit
    Created on : 28.Nis.2016, 18:36:16
    Author     : must
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>JSP Page</title>
        <jsp:include page="html/head.html"/>
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
                        <c:when test="${vakifolusturuldu eq 1}">
                           <div id="alert" class="alert alert-success">
                                <strong>Başarılı!</strong> Vakıf Oluşturuldu
                            </div>
                        </c:when>
                        <c:when test="${vakifolusturuldu eq 2}">
                           <div id="alert" class="alert alert-danger">
                                <strong>Başarısız!</strong> Vakıf Oluşturulamadı
                            </div>
                        </c:when>
                    </c:choose>
                    <h3>Yeni Bağış Kabul Birimi Ekleyin</h3>
                    <p>Lütfen istenen bilgileri eksiksiz giriniz</p> 
                    <form method="post" action="../createdonationunitservlet" >
                        <table id="formTable" class="table">
                          <tbody>
                            <tr>
                              <td>Birimin Adı</td>
                              <td><input type="text" name="unit_name"/></td>
                            </tr>
                            <tr><td colspan="2"><button type="submit" class="btn btn-default">Vakıf Oluştur</button></td></tr>
                          </tbody>
                        </table>
                    </form>
                    <c:choose>
                        <c:when test="${kullanicieklendi eq 1}">
                           <div id="alert" class="alert alert-success">
                                <strong>Başarılı!</strong> Kullanıcı Oluşturuldu
                            </div>
                        </c:when>
                        <c:when test="${kullanicieklendi eq 2}">
                           <div id="alert" class="alert alert-danger">
                                <strong>Başarısız!</strong> Kullanıcı Oluşturulamadı
                            </div>
                        </c:when>
                    </c:choose>
                    <h3>Kullanıcı Ekleyin
                        <c:choose>
                            <c:when test="${dauUser ne null}">
                               ${dauUser.unitName} için
                            </c:when>                     
                        </c:choose>
                    </h3>
                    <form method="post" action="../adddauuserservlet">
                        <table id="formTable" class="table">
                            <tbody>
                                <tr>
                                    <td>Kullanıcı Adı</br></td>
                                    <td><input type="text" name="user_name"/></td>
                                </tr>
                                <tr>
                                  <td>Geçici Parola</td>
                                  <td><input type="text" name="password"/></td>
                                </tr>
                                <tr><td colspan="2"><button type="submit" class="btn btn-default">Kullanıcı Ekle</button></td></tr>
                            </tbody>
                        </table>
                    </form>
                    <c:choose>
                        <c:when test="${hesapeklendi eq 1}">
                           <div id="alert" class="alert alert-success">
                                <strong>Başarılı!</strong> Banka hesabı eklendi
                            </div>
                        </c:when>
                        <c:when test="${hesapeklendi eq 2}">
                           <div id="alert" class="alert alert-danger">
                                <strong>Başarısız!</strong> Banka hesabı eklenemedi
                            </div>
                        </c:when>
                    </c:choose>
                    <h3>Banka Hesabı Ekleyin
                        <c:choose>
                            <c:when test="${dauUser ne null}">
                               ${dauUser.unitName} için
                            </c:when>                     
                        </c:choose>
                    </h3>
                    <form method="post" action="../addbankaccountservlet">
                        <table id="formTable" class="table">
                            <tbody>
                                <tr>
                              <td>Banka Adı</br></td>
                              <td><input type="text" name="bank_name"/></td>
                            </tr>
                            <tr>
                              <td>Şube Adı</br></td>
                              <td><input type="text" name="name_of_branch"/></td>
                            </tr>
                            <tr>
                              <td>Hesap No</br></td>
                              <td><input type="text" name="account_number"/></td>
                            </tr>
                            <tr>
                              <td>Para Birimi</td>
                              <td> <select name="currency">
                                    <c:forEach var="item" items="${curr}">
                                        <option value="${item.id}">
                                            <c:out value="${item.title}"/>
                                        </option>
                                    </c:forEach>
                                </select></br></td>
                            </tr>
                            <tr>
                                <td>IBAN</td>
                                <td><input type="text" name="iban"/></td>
                            </tr>
                            <tr><td colspan="2"><button type="submit" class="btn btn-default">Banka Hesabı Oluştur</button></td></tr>
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
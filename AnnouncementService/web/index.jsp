<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="tr">
    <head>
    <title>Anasayfa</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mycss.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="html/header.html"></jsp:include>
            <div class="text-center">
                <h3>Yıldız Teknik Üniversitesi İlan Yayınlama Servisine Hoşgeldiniz!</h3>
                <h3>
                    Hem ilanlarınızı yayınlamak, hem de öğrenciler için bağış yaparak
                    eğitimlerine katkıda bulunmak ister misiniz?
                </h3>
                <h3>
                    <a href="nasil-calisir.jsp">Nasıl Çalışır?</a> sayfamızdan detayları öğrenebilirsiniz
                </h3>
            </div>
        </div>
        <div class="row">
            <div id="footer" class="col-md-12">
                <jsp:include page="html/footer.html"/>  
            </div>
        </div>
    </div>
</body>
</html>
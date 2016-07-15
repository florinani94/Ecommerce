<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nicoletatica
  Date: 15/07/2016
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:url var="cssUrl" value="/resources/style/PaginatorStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrl}">

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <title>Tea Shop</title>
</head>
<c:url var="bkgURL" value="/resources/orangeBackground.jpg"/>
<c:url var="backofficeURL" value="/backoffice/product/"/>
<c:url var="customerURL" value="/products"/>
<body style="background-image: url(${bkgURL});
        background-repeat: no-repeat;)">
<div class="row" style="margin-top: 5%">
    <div class="col-md-2 col-md-offset-5" style="text-align: center;">
        <h1>TEA SHOP</h1>
    </div>
</div>

<div class="row" style="margin-top: 9%">
    <div class="col-md-6 col-md-offset-3">
            <b>
                <p style="text-align: center; font-family: SansSerif">
                    Tea is an aromatic beverage commonly prepared by pouring hot or boiling water over cured leaves of the Camellia sinensis, an evergreen shrub native to Asia.
                    After water, it is the most widely consumed drink in the world.
                    <br>
                    There are many different types of tea; some teas, like Darjeeling and Chinese greens,
                    have a cooling, slightly bitter, and astringent flavour, while others have vastly different profiles that include sweet, nutty, floral or grassy notes.
                    <br><br>
                    Tea originated in southwestern China, where it was used as a medicinal drink. It was popularized as a recreational drink during the Chinese Tang dynasty,
                    and tea drinking spread to other East Asian countries.
                    <br>
                    Portuguese priests and merchants introduced it to the West during the 16th century.
                    <br>
                    During the 17th century,
                    drinking tea became fashionable among Britons, who started large-scale production and commercialization of the plant in India to bypass a Chinese monopoly at that time.
                </p>
            </b>
    </div>
</div>
<div class="row" style="margin-top: 12%">
    <div class="col-md-2 col-md-offset-4">
        <a href="${backofficeURL}">
            <input type="submit" name="backoffice" value="Backoffice page" class="btn btn-primary"/>
        </a>
    </div>

    <div class="col-md-2 col-md-offset-1">
        <a href="${customerURL}">
            <input type="submit" name="action" value="Customer page" class="btn btn-primary"/>
        </a>
    </div>
</div>

</body>
</html>

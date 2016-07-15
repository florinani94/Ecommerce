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
    <h1 style="text-align: center">TEA SHOP</h1>
    <div style=" top: 70%; left: 20%; text-align: center ">
        <b>
        <p>
            Tea is an aromatic beverage commonly prepared by pouring hot or boiling water over cured leaves of the Camellia sinensis, an evergreen shrub native to Asia.<br>
            After water, it is the most widely consumed drink in the world.[5] There are many different types of tea; some teas, like Darjeeling and Chinese greens,<br>
            have a cooling, slightly bitter, and astringent flavour,[6] while others have vastly different profiles that include sweet, nutty, floral or grassy notes. <br>
        </p>
        <p>
            Tea originated in southwestern China, where it was used as a medicinal drink.[7] It was popularized as a recreational drink during the Chinese Tang dynasty,<br>
            and tea drinking spread to other East Asian countries. Portuguese priests and merchants introduced it to the West during the 16th century.[8] During the 17th century, <br>
            drinking tea became fashionable among Britons, who started large-scale production and commercialization of the plant in India to bypass a Chinese monopoly at that time. <br>
        </p>
        <p>
            The phrase herbal tea usually refers to infusions of fruit or herbs made without the tea plant, such as steeps of rosehip, chamomile, or rooibos. <br>
            These are also known as tisanes or herbal infusions to distinguish them from "tea" as it is commonly construed.
        </p>
        </b>
    </div>
    <a href="${backofficeURL}">
        <input type="submit" name="backoffice" value="Backoffice page" style=" position: fixed;top: 32%; left: 42%; width:150px;height:45px"/>
    </a>

    <a href="${customerURL}">
        <input type="submit" name="action" value="Customer page" style=" position: fixed;top: 32%; left:52%; width:150px;height:45px" />
</a>


</body>
</html>

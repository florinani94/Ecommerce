<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateimihai
  Date: 7/18/2016
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="imageTileURL" value="/resources/detailView/SimpleLogo.png"/>
<c:url var="backgroundURL" value="/resources/detailView/Background2.jpg"/>
<c:url var="detailsCSSURL" value="/resources/style/detailViewStyle.css"/>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${detailsCSSURL}">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <title>${theProduct.name}</title>

</head>
<body background="${backgroundURL}" style="background-size: 100%">
<jsp:include page="customerHeader.jsp" />
<div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
        <div class="row" style="margin-top: 5%">
            <div class="col-sm-6" >
                <img src="${imageTileURL}" class="img-responsive" alt="Picture not available" width="500" height="375" id="imageCell"></img>
            </div>
            <div class="col-sm-6" id="productInfo">
                <h1 class="pageText" id="productTitle">${theProduct.name}</h1>
                <br>
                <table class="detailsText" id="productDetails">
                    <tr><td class="descriptionText">${theProduct.description}</td>
                    </tr>
                    <tr><td class="priceText">Price:</td>
                    </tr>
                    <tr><td class="priceText">${theProduct.price} $</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="col-sm-1"></div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: dianamohanu
  Date: 20/07/2016
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<c:url var="detailsCSSURL" value="/resources/style/detailViewStyle.css"/>
<link rel="stylesheet" type="text/css" href="${detailsCSSURL}">

<head>
    <title>Confirm Account</title>
</head>
<body>
<jsp:include page="customerHeader.jsp" />

<div class="row-fluid">
    <div class="col-sm-4"></div>

    <div class="col-sm-4" id="confirmInfo">
        <div class="row-fluid" style="margin-top: 10%">
            <h1 class="pageText" id="productTitle">Success!</h1>
            <div class="myHr"></div>
            <table class="detailsText" id="confirmDetails">
                <tr>
                    <td><h2 style="color: #808080; font-family: 'Calibri';">${message}</h2></td>
                </tr>
                <tr>
                    <td class="priceText">
                        <form action="login" method="get">
                            <button type="submit" class="btn btn-success">Login now!</button>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div class="col-sm-4"></div>
</div>

</body>
</html>

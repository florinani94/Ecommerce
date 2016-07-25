<%--
  Created by IntelliJ IDEA.
  User: dianamohanu
  Date: 25/07/2016
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<c:url var="detailsCSSURL" value="/resources/style/detailViewStyle.css"/>
<link rel="stylesheet" type="text/css" href="${detailsCSSURL}">

<c:url var="backgroundURL" value="/resources/detailView/Background2.jpg"/>

<head>
    <title>My Cart</title>
</head>
<body background="${backgroundURL}" style="background-size: 100%">
<jsp:include page="customerHeader.jsp" />

<br>
<div class="row-fluid">
    <div class="col-sm-3"></div>

    <div class="col-sm-6">
        <h1 id="productTitle">My Cart</h1>
        <div class="myHr"></div>

        <c:forEach var="entry" items="${entries}">
            <tr>
                <td>${entry.productCode}</td>
            </tr>
        </c:forEach>

    </div>

    <div class="col-sm-3"></div>
</div>

</body>
</html>

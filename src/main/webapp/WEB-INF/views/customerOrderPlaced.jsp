<%--
  Created by IntelliJ IDEA.
  User: iuliacodau
  Date: 25/07/2016
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

    <c:url var="cssUrl" value="/resources/style/PaginatorStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrl}">
    <c:url var="cssUrlHead" value="/resources/style/detailViewStyle.css"></c:url>
    <link rel="stylesheet" href="${cssUrlHead}">
    <c:url var="bkgURL2" value="/resources/detailView/Background2.jpg"></c:url>

    <title>Order Placed</title>
</head>

<body style="background-image:url(${bkgURL2});background-repeat: repeat; background-size: 100%; )">

<jsp:include page="customerHeader.jsp" />
<c:url var="addressUrl" value="/products/checkout"></c:url>
<c:url var="backUrl" value="/products"></c:url>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1> <b> Order Placed </b></h1>
        <br><br>
        <h4> Thank you for your order! </h4>
        <h4> Check your email for further details</h4>
    </div>
</div>


<c:url var="jqueyUrl" value="/resources/jquery-1.8.3.js"/>
<script type="text/javascript" src="${jqueyUrl}"></script>

<c:url var="jsUrl" value="/resources/js/myscript.js"/>
<script type="text/javascript" src="${jsUrl}"></script>

</body>
</html>

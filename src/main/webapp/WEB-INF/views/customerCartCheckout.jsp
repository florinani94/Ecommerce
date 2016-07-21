<%--
  Created by IntelliJ IDEA.
  User: iuliacodau
  Date: 19/07/2016
  Time: 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<%--    <link rel="stylesheet" type="text/css" href="${cssUrl}">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

    <script
            src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>--%>

    <c:url var="cssUrl" value="/resources/style/PaginatorStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrl}">

    <c:url var="cssUrlHead" value="/resources/style/detailViewStyle.css"></c:url>
    <link rel="stylesheet" href="${cssUrlHead}">


    <c:url var="bkgURL2" value="/resources/detailView/Background2.jpg"></c:url>

    <title>Cart Checkout</title>
</head>

<body style="background-image:url(${bkgURL2});background-repeat: no-repeat; background-size: 100%; )">

<jsp:include page="customerHeader.jsp" />
<c:url var="addressUrl" value="/products/address"></c:url>
<c:url var="backUrl" value="/products"></c:url>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1> <b> Checkout - Part 1</b></h1>
    </div>
</div>

<c:if test="${data == null}">

<form action="address" method="post" id="checkoutAddress" class="form-inline">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">

                <b>Delivery Address:</b>
                <br><br>
                Street: <br>
                <input type="text" id="deliveryStreet" name="deliveryStreet" maxlength="30" class="form-control"/>
                <br><br>
                Number: <br>
                <input type="text" id="deliveryNumber" name="deliveryNumber" maxlength="5" class="form-control"/>
                <br><br>
                City: <br>
                <input type="text" id="deliveryCity" name="deliveryCity" maxlength="15" class="form-control"/>
                <br><br>
                Phone <br>
                <input type="text" id="deliveryPhone" name="deliveryPhone" maxlength="10" class="form-control"/>
                <br><br>

        </div>
    </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-4">

                    <b>Billing Address:</b>
                    <br><br>
                    <div class="panel-heading">
                    <h4 class="panel-title">
                    <a data-toggle="collapse" href="#collapseAddress">
                        <input type="checkbox" id="same" name="same" onchange="billingFunction()"> Use the same address
                    </a>
                    </h4>
                    </div>
                    <div class="collapse" id="collapseAddress">
                    Street: <br>
                    <input type="text" id="billingStreet" name="billingStreet" maxlength="30" class="form-control"/>
                    <br><br>
                    Number: <br>
                    <input type="text" id="billingNumber" name="billingNumber" maxlength="5" class="form-control"/>
                    <br><br>
                    City: <br>
                    <input type="text" id="billingCity" name="billingCity" maxlength="10" class="form-control"/>
                    <br><br>
                    Phone <br>
                    <input type="text" id="billingPhone" name="billingPhone" maxlength="10" class="form-control"/>
                    <br><br>

                    </div>

            </div>
        </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <input type="submit" value="Continue" class="btn btn-success">
            <a href="backUrl" class="btn btn-default" role="button"> Cancel </a>
        </div>
    </div>
    </form>

</c:if>

<c:if test="${data == true}">
    <a href="${addressUrl}" class="btn btn-default" role="button"> New Address </a>
</c:if>

<c:if test="${data == false}">
    <h3>Incorrect</h3>
    <a href="${addressUrl}" class="btn btn-default" role="button"> New Address </a>
</c:if>

<c:url var="jqueyUrl" value="/resources/jquery-1.8.3.js"/>
<script type="text/javascript" src="${jqueyUrl}"></script>

<c:url var="jsUrl" value="/resources/js/myscript.js"/>
<script type="text/javascript" src="${jsUrl}"></script>

</body>
</html>

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
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

    <c:url var="paymentUrl" value="/resources/secure.png"></c:url>
    <c:url var="cssUrl" value="/resources/style/PaginatorStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrl}">
    <c:url var="cssUrlHead" value="/resources/style/detailViewStyle.css"></c:url>
    <link rel="stylesheet" href="${cssUrlHead}">
    <c:url var="bkgURL2" value="/resources/detailView/Background2.jpg"></c:url>

    <title>Cart Checkout</title>
</head>

<body style="background-image:url(${bkgURL2});background-repeat: repeat; background-size: 100%; )">

<jsp:include page="customerHeader.jsp" />
<c:url var="addressUrl" value="/products/checkout"></c:url>
<c:url var="backUrl" value="/products"></c:url>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1> <b> Checkout - Part 1</b></h1>
    </div>
</div>

<c:if test="${data == null || data==false}">
    <%--
    <form action="address" method="post" id="checkoutAddress" class="form-inline" action="${addressUrl}" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">

                    <b>Delivery Address </b>
                    <br><br>
     &lt;%&ndash;               Street: <br>
                    <input type="text" id="deliveryStreet" name="deliveryStreet" maxlength="30" required class="form-control"/>
                    <br><br>&ndash;%&gt;
                    Number: <br>
                    <input type="text" id="deliveryNumber" name="deliveryNumber" maxlength="5" required class="form-control"/>
                    <br><br>
                    City: <br>
                    <input type="text" id="deliveryCity" name="deliveryCity" maxlength="15" required class="form-control"/>
                    <br><br>
                    Phone <br>
                    <input type="text" id="deliveryPhone" name="deliveryPhone" maxlength="10" required class="form-control"/>
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
                        <input type="text" id="billingStreet" name="billingStreet" maxlength="30" required class="form-control"/>
                        <br><br>
                        Number: <br>
                        <input type="text" id="billingNumber" name="billingNumber" maxlength="5" required class="form-control"/>
                        <br><br>
                        City: <br>
                        <input type="text" id="billingCity" name="billingCity" maxlength="10" required class="form-control"/>
                        <br><br>
                        Phone <br>
                        <input type="text" id="billingPhone" name="billingPhone" maxlength="10" required class="form-control"/>
                        <br><br>

                        </div>

                </div>
            </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <input type="submit" value="Continue" class="btn btn-success">
                <a href="${backUrl}" class="btn btn-default" role="button"> Cancel </a>
            </div>
        </div>
        </form>

    </c:if>

    <c:if test="${data == true}">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
        <a href="${addressUrl}" class="btn btn-default" role="button"> Next </a>
        </div>
    </div>
    </c:if>

    <c:if test="${data == false}">
        <h3>Incorrect</h3>
        <div class="row">
        <div class="col-md-4 col-md-offset-4">
        <a href="${addressUrl}" class="btn btn-default" role="button"> New Address </a>
        </div>
        </div>
    </c:if>--%>




<form:form commandName="order" method="POST" action="${addressUrl}" id="checkoutAddress" class="form-inline" ><%--cssClass="form-horizontal registrationForm" enctype="multipart/form-data"--%>

    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <b>1. Contact Details </b>
            <br><br>

<%--            <label for="name">Name : </label>
            <br>
            <form:input path="name" id="name" cssClass="form-control" maxlength="10" required="true" />
            <br><br>--%>
            <label for="email">E-mail Address : </label>
            <br>
            <form:input path="email" id="email" cssClass="form-control" maxlength="10" required="true" />
            <br><br>
        </div>
    </div>


    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <b>2. Delivery Address </b>
            <br><br>

            <label for="deliveryStreet">ID : </label>
            <br>
            <form:input readonly="true" path="cartId" cssClass="form-control" maxlength="10" required="true" />
            <br><br>

        <label for="deliveryStreet">Street : </label>
            <br>
        <form:input path="deliveryStreet" id="deliveryStreet" cssClass="form-control" maxlength="10" required="true" />
        <br><br>
        <label for="deliveryNumber">Number : </label>
            <br>
        <form:input path="deliveryNumber" id="deliveryNumber" cssClass="form-control" maxlength="5" required="true" />
        <br><br>
        <label for="deliveryCity">City : </label>
            <br>
        <form:input path="deliveryCity" id="deliveryCity" cssClass="form-control" maxlength="5" required="true" />
        <br><br>
        <label for="deliveryPhone">Phone : </label>
            <br>
        <form:input path="deliveryPhone" id="deliveryPhone" cssClass="form-control" maxlength="5" required="true" />
        <br><br>
        </div>
    </div>


    <div class="row">
        <div class="col-md-4 col-md-offset-4">

            <b>3. Billing Address:</b>
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
                <form:input path="billingStreet" id="billingStreet" cssClass="form-control" maxlength="10" required="true" />
                <br><br>
                Number: <br>
                <form:input path="billingNumber" id="billingNumber" cssClass="form-control" maxlength="10" required="true" />
                <br><br>
                City: <br>
                <form:input path="billingCity" id="billingCity" cssClass="form-control" maxlength="10" required="true" />
                <br><br>
                Phone <br>
                <form:input path="billingPhone" id="billingPhone" cssClass="form-control" maxlength="10" required="true" />
                <br><br>

            </div>

        </div>
    </div>


    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <img src="${paymentUrl}" />
                <br><br>
                <b>4. Payment Details</b>
                <br><br>

                <label for="paymentMethod">Payment Method : </label>
                <br>
                <form:input path="paymentMethod" id="paymentMethod" cssClass="form-control" maxlength="10" required="true" />
                <br><br>
                <label for="cardNumber">Card Number : </label>
                <br>
                <form:input path="cardNumber" id="deliveryStreet" cssClass="form-control" maxlength="10" required="true" />
                <br><br>
                <label for="cardCode">Card Code : </label>
                <br>
                <form:input path="cardCode" id="cardCode" cssClass="form-control" maxlength="5" required="true" />
                <br><br>
            </div>
        </div>


    <div class="form-group">
        <div class="col-xs-offset-2 col-xs-10">
            <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
        </div>
    </div>
</form:form>


</c:if>







<c:url var="jqueyUrl" value="/resources/jquery-1.8.3.js"/>
<script type="text/javascript" src="${jqueyUrl}"></script>

<c:url var="jsUrl" value="/resources/js/myscript.js"/>
<script type="text/javascript" src="${jsUrl}"></script>

</body>
</html>

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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<c:url var="detailsCSSURL" value="/resources/style/detailViewStyle.css"/>
<link rel="stylesheet" type="text/css" href="${detailsCSSURL}">

<c:url var="backgroundURL" value="/resources/detailView/Background2.jpg"/>

<head>
    <title>My Cart</title>

    <style>
        #viewProductsTable {
            width:50%;
            margin-top: 5%;
        }
    </style>

</head>
<body background="${backgroundURL}" style="background-size: 100%">
<jsp:include page="customerHeader.jsp" />

<br>
<div class="row-fluid">
    <div class="col-md-3"></div>

    <div class="col-md-6">
        <h1 id="productTitle">My Cart</h1>
        <div class="myHr"></div>

        <c:forEach var="entry" items="${entries}">
            <div class="row">
            <h4 class="text-uppercase"><strong>${entry.productName}</strong></h4>
            <br>

                <div class="col-md-3">
                    <c:url var="img" value="${entry.product.imageURL}"/>
                    <img src="${img}" style="height: 120px; width: 175px;">
                </div>

                <div class="col-md-9">
                    <table id="viewProductsTable">
                        <tr>
                            <th>CODE</th>
                            <th>PRICE</th>
                            <th>QUANTITY</th>
                            <th>ITEM TOTAL</th>
                        </tr>
                        <tr>
                            <td>${entry.productCode}</td>
                            <td>${entry.productPrice} $</td>
                            <td>${entry.quantity}</td>
                            <td>${entry.subTotal}</td>
                        </tr>
                        <tr>
                            <a id="removeEntryBtn${entry.entryId}" onclick="myfunction(${entry.entryId})">Remove</a>
                        </tr>
                    </table>
                </div>
            </div>
            <br>
            <div class="myHr"></div>
        </c:forEach>

        <h1>CART TOTAL: ${total}</h1>
    </div>

    <div class="col-md-3"></div>
</div>

<jsp:include page="customerFooter.jsp"/>

<script type="text/javascript">
    function myfunction (val) {
        console.log(val);

        $.ajax({
            type : "POST",
            url : contextURL + "cart/view",
            data : {
                entryId: val
            },
            success : function(response) {
                $("#removeEntryBtn" + val).parent().remove();
                console.log("success");
            },
            error : function(e) {
                alert('Error: ' + e);
            }
        });
    }

</script>

</body>
</html>

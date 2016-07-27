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
        .entryTitle {
            font-family: Calibri;
            color: rgb(114, 114, 114);
            font-size: 22px;
            text-decoration: underline;
        }

        a:not([href]) {
            font-family: Calibri;
            color: rgb(204, 102, 0);
            text-decoration: underline;
            font-size: 20px;
        }

        a:not([href]):hover {
            font-family: Calibri;
            cursor: pointer;
            color: rgb(153, 77, 0);
            font-size: 20px;
        }

        #stockLabel {
            font-family: Calibri;
            color: rgb(102, 153, 0);
        }

        th, td {
            color: rgb(114, 114, 114);
            font-family: Calibri;
            font-size: 18px;
        }

        .row-buffer {
            margin-top: 20px;
            background-color: #FFFFFF;
            height: 25%;
        }
    </style>

</head>
<body background="${backgroundURL}" style="background-size: 100%; ">
<jsp:include page="customerHeader.jsp"/>

<br>
<div class="row-fluid">
    <div class="col-md-3"></div>

    <div class="col-md-5">
        <h1 id="productTitle">My Cart</h1>
        <div class="myHr"></div>

        <c:forEach var="entry" items="${entries}">
            <div class="row row-buffer">
                <h4 class="entryTitle">${entry.productName}</h4>
                <br>
                <div class="col-md-3">
                    <c:url var="img" value="${entry.product.imageURL}"/>
                    <img src="${img}" style="height: 140px; width: 204px;">
                </div>

                <div class="col-md-9">
                    <table style="width: 70%">
                        <tr>
                            <th>CODE</th>
                            <th>PRICE</th>
                            <th>QUANTITY</th>
                            <th>ITEM TOTAL</th>
                        </tr>
                        <tr>
                            <td>${entry.productCode}</td>
                            <td>${entry.productPrice}</td>

                            <td><select id="quantityOptions${entry.entryId}">
                                <c:forEach begin="1" end="${entry.product.stockLevel}" var="val">
                                    <c:if test="${val == entry.quantity}">
                                        <option selected>${val}</option>
                                    </c:if>

                                    <c:if test="${val != entry.quantity}">
                                        <option>${val}</option>
                                    </c:if>
                                </c:forEach>
                            </select></td>

                            <td id="subTotal${entry.entryId}">${entry.subTotal}</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td><a id="editEntryBtn${entry.entryId}" onclick="editfunction(${entry.entryId})">Update</a>
                            </td>
                        </tr>
                        <tr>
                            <c:if test="${entry.product.stockLevel != 0}">
                                <td colspan="4"><h4 id="stockLabel"><strong>In Stock & Ready To Ship</strong></h4></td>
                            </c:if>
                        </tr>
                        <tr>
                            <td><a id="removeEntryBtn${entry.entryId}"
                                   onclick="deletefunction(${entry.entryId})">Remove</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </c:forEach>

        <div id="totalCartPrice">
            <h1>CART TOTAL: ${total}</h1>
        </div>
    </div>

    <div class="col-md-4"></div>
</div>

<script type="text/javascript">
    function deletefunction(val) {
        $.ajax({
            type: "POST",
            url: contextURL + "cart/view",
            data: {
                entryId: val
            },
            success: function (response) {
                $("#removeEntryBtn" + val).parent().parent().parent().parent().parent().parent().remove();
                $("#totalCartPrice").load(contextURL + "cart/ #totalCartPrice");

                console.log("success");
            },
            error: function (e) {
                alert('Error: ' + e);
            }
        });
    }

    function editfunction(val) {
        var quantity = $('#quantityOptions' + val).find(":selected").text();

        $.ajax({
            type: "POST",
            url: contextURL + "cart/edit",
            data: {
                entryId: val,
                newQuantity: quantity
            },
            success: function (response) {
                $("#subTotal" + val).load(contextURL + "cart/ #subTotal" + val);
                $("#totalCartPrice").load(contextURL + "cart/ #totalCartPrice");
                console.log("success");
            },
            error: function (e) {
                alert('Error: ' + e);
            }
        });

    }
</script>

<jsp:include page="customerFooter.jsp"/>

</body>
</html>

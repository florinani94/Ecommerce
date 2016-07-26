<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="imageTileURL" value="${theProduct.imageURL}"/>
<c:url var="backgroundURL" value="/resources/detailView/Background2.jpg"/>
<c:url var="detailsCSSURL" value="/resources/style/detailViewStyle.css"/>

<html>
<head>
    <%--todo: create a css.tag and js. tag and move these files--%>
    <link rel="stylesheet" type="text/css" href="${detailsCSSURL}">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <title>${theProduct.name}</title>
    <%--todo: move to a ccs file--%>
    <style>
        .quantity {
            text-align:center;
            width: 80%;
            margin-top: -18%;
            margin-left: 20%;
            padding: 6px 5px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
    </style>

</head>
<body background="${backgroundURL}" style="background-size: 100%">

<jsp:include page="customerHeader.jsp" />

<input type="hidden" id="product-id" value="${theProduct.productId}"/>

<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <div class="row" style="margin-top: 5%">
            <div class="col-md-7" >
                <img src="${imageTileURL}" class="img-responsive" alt="Picture not available" width="650" height="400" id="imageCell"/>
            </div>
            <div class="col-md-5" id="productInfo">
                <h1 class="pageText" id="productTitle">${theProduct.name}</h1>
                <div class="myHr"></div>
                    <table class="detailsText" id="productDetails">
                        <tr>
                            <td class="descriptionText">
                                <div class="categoryName">${theProduct.category.name}
                                </div>
                                ${theProduct.description}
                            </td>
                        </tr>
                        <tr>
                            <td class="priceText">${theProduct.price}$</td>
                        </tr>
                        <tr>
                            <td><input type="submit" class="addButton" id="addButtonID" nicholas-cage="${theProduct.productId}" value="Add to cart"> </td>
                        </tr>
                        <tr>
                            <td>
                            <b>Quantity: </b>
                            <td><input type="number" min="1" value="1" id="quantityFieldID" class="quantity"></td>
                        </tr>
                    </table>
            </div>
        </div>
    </div>

</div>

<jsp:include page="customerFooter.jsp"/>

</body>
</html>

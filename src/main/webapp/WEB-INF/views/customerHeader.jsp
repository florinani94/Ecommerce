<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <c:url var="homeURL" value="/products"/>
    <c:url var="loginURL" value="/login"/>

    <c:url var="logoUrl" value="/resources/detailView/SizedLogo.png"></c:url>
    <c:url var="textUrl" value="/resources/detailView/SizedText.png"></c:url>
    <c:url var="cartImageUrl" value="/resources/detailView/cartIcon.png"></c:url>
    <c:url var="cartJavaScriptUrl" value="/resources/js/cartBehaviour.js"></c:url>
    <c:url var="checkoutURL" value="/products/address"></c:url>

    <%--<link rel="stylesheet" href="/resources/style/detailViewStyle.css">--%>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <title>Tea Shop</title>
</head>
<body>
    <div class="row header">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="row">
                <div class="col-sm-6">
                     <a href="${homeURL}">
                        <img id="teaLogo"  src="${logoUrl}" alt="Tea House" ismap>
                     </a>
                </div>
                <div class="col-sm-6">
                    <div id="headerLinks">
                        <a class="headerLink" href="${checkoutURL}">
                            Checkout</a>
                        <a class="headerLink" href="${loginURL}">
                            Login</a>
                        <a>
                            <img  src="${cartImageUrl}" alt="My Cart" id="cartIcon" ismap></a>

                        <div id="cartPanel">
                            A<br>B<br>C<br>D<br>E
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>

    <script src="/mvc/resources/jquery-1.8.3.js"></script>
    <script type="application/javascript" src="${cartJavaScriptUrl}"></script>

</body>
</html>

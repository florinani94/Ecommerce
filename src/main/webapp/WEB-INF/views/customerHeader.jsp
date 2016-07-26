<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <c:url var="homeURL" value="/products"/>
    <c:url var="loginURL" value="/login"/>

    <c:url var="logoUrl" value="/resources/detailView/SizedLogo.png"></c:url>
    <c:url var="textUrl" value="/resources/detailView/SizedText.png"></c:url>
    <c:url var="cartImageUrl" value="/resources/detailView/cartIcon.png"></c:url>
    <c:url var="cartJavaScriptUrl" value="/resources/js/cartBehaviour.js"></c:url>
    <c:url var="checkoutURL" value="/products/address"></c:url>

    <c:url var="logoutUrl" value="/j_spring_security_logout"/>

    <%--<link rel="stylesheet" href="/resources/style/detailViewStyle.css">--%>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <jsp:include page="variables.jsp"/>

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
                        <sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
                            <h4 style="color: #FFFFFF; padding-left: 1%; font-family: 'Calibri';"> Logged in as: <sec:authentication property="name"/> | <a href="${logoutUrl}">Logout</a> </h4>
                        </sec:authorize>

                        <sec:authorize access="!hasRole('ROLE_ADMIN')">
                            <a class="headerLink" href="${loginURL}">
                                Login</a>
                        </sec:authorize>

                        <a class="headerLink" href="${checkoutURL}">
                            Checkout</a>

                        <a>
                            <img  src="${cartImageUrl}" alt="My Cart" id="cartIcon" ismap></a>

                        <div id="cartPanel">
                            <div id="allCartData">
                                <div id="entry-data">

                                </div>
                                <div id = "totalTag">
                                    total:
                                    <span id="total-value"></span>
                                    $
                                </div>
                            </div>
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

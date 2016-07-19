<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <c:url var="homeURL" value="/products"/>
    <c:url var="logoUrl" value="/resources/detailView/SizedLogo.png"></c:url>
    <c:url var="textUrl" value="/resources/detailView/SizedText.png"></c:url>

    <link rel="stylesheet" type="text/css" href="${cssUrl}">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <title>Tea Shop</title>
</head>
<body>
    <table class="pageLayout" border="0">
        <tr>
            <td>
                <a id="teaLogo" href="${homeURL}">
                    <img src="${logoUrl}" alt="Tea House" ismap></a>
                <a id="logoText" href="${homeURL}">
                    <img src="${textUrl}" alt="There is always time for tea" ismap></a>
            </td>
            <td>
                <div id="headerLinks">
                    <a class="headerLink" href="${homeURL}">
                        My cart
                    </a>

                    <a class="headerLink" href="${homeURL}">
                        Checkout
                    </a>

                    <a class="headerLink" href="${homeURL}">
                        Login
                    </a>
                </div>
            </td>
        </tr>
    </table>
</body>
</html>

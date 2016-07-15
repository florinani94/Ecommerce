<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <style>
        .logo{
            margin-top: 17%;
            text-align: center;
        }
    </style>

    <c:url var="homePage" value="/home"></c:url>
    <c:url var="backgroundResUrl" value="/resources/background2.jpg"></c:url>
    <c:url var="logoResUrl" value="/resources/teaLogo.png"></c:url>
</head>
<body background="${backgroundResUrl}" style="background-size: 100%">
    <p class="logo">
    <a href="${homePage}">
        <img align="middle" src="${logoResUrl}" alt="Welcome!"> </img>
    </a>
    </p>
</body>
</html>
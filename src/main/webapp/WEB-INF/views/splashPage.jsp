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
</head>
<body background="/orangeBackground.jpg">
    <c:url var="homePage" url="/home"></c:url>
    <p class="logo">
    <a href="${homePage}"
        <img align="middle" src="/teaLogo.png" alt="Welcome!"> </img>
    </a>
    </p>
</body>
</html>
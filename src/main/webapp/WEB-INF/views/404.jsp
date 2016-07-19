<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

    <script
            src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <c:url var="URL404" value="/resources/404.png"/>

    <title>404 Not found</title>
</head>
<body background="${URL404}" style="background-size: 100%">

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1 style="color: white; text-align: center">You are a little bit lost</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h3 style="color: white; text-align: center">Here are some links to guide you </h3>
    </div>
</div>

<div class="row">
    <div class="col-md-1 col-md-offset-5">
        <a class="btn btn-default" href="/mvc/home">Home</a>
    </div>
    <div class="col-md-1">
        <a class="btn btn-default" href="/mvc/products">Products page</a>
    </div>
</div>

</body>
</html>
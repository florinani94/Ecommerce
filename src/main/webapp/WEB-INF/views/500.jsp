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

    <c:url var="URL500" value="/resources/500.png"/>

    <title>404 Not found</title>
</head>
<body>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h1 style="text-align: center">We apologise</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <img src="${URL500}" alt="500Error" width="590" height="300">
    </div>
</div>

<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <h3 style="text-align: center">Here are some useful links</h3>
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
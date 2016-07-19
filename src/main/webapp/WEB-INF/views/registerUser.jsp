<%--
  Created by IntelliJ IDEA.
  User: dianamohanu
  Date: 18/07/2016
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<head>
    <title>Register User</title>
</head>
<body>
<c:url var="signIn" value="/backoffice/product/"/>

<div class="col-md-6 col-md-offset-4">
    <h1>REGISTER</h1>
    <h3>Create back-office user account</h3>
    <br> <br>
    <form action="register" method="post">
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="email">Email:</label> <input type="email"
                                                         class="form-control" id="email"
                                                         placeholder="myemail@example.com">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="username">Username:</label> <input type="text"
                                                               class="form-control" id="username" placeholder="user1">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="pass1">Password:</label> <input type="password"
                                                            class="form-control" id="pass1"
                                                            placeholder="Enter password">
					<span class="help-block">Password must be at least 6
						characters.</span>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-lg-5">
                <label for="pass2">Confirm Password:</label> <input type="password"
                                                                    class="form-control" id="pass2"
                                                                    placeholder="Confirm password">
            </div>
        </div>
        <button type="submit" class="btn btn-warning">Create Account</button>
    </form>

    <br>
    <p>
        Already a back-office user? <a href="${signIn}">Sign In.</a>
    </p>

    <h4 style="color: #FFA500;">${message1}</h4>
    <h4 style="color: #FFA500;">${message2}</h4>
</div>

<c:url var="jqueyUrl" value="/resources/jquery-1.8.3.js"/>
<script type="text/javascript" src="${jqueyUrl}"></script>

<c:url var="jsUrl" value="/resources/js/myscript.js"/>
<script type="text/javascript" src="${jsUrl}"></script>
</body>
</html>

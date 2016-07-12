<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihai
  Date: 7/12/2016
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create category</title>

</head>
<body>

<h1>Create Category</h1>
<form action="addCategory" method="post">
    Id: <br>
    <input type="text" name="id"/> <br><br>
    Name: <br>
    <input type="text" name="name"/> <br><br>
    Description: <br>
    <input type="text" name="description"/> <br><br>
    <input type="submit" value="Save"/>
</form>

<c:if test="${message == true}">
    <h1>Category added</h1>
</c:if>
<c:if test="${message == false}">
    <h1>You have errors ! The category was not added</h1>
</c:if>

</body>
</html>

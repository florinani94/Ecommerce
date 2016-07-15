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

<jsp:include page="backofficeHeader.jsp" />

<h1>Create Category</h1>
<form action="add" method="post" id="addCat">
    Id: <br>
    <input type="text" name="id"/>
    <br><br>
    Name: <br>
    <input type="text" name="name"/>
    <br><br>
    Description: <br>
    <textarea rows="4" cols="50" name="description" form="addCat"></textarea>
    <br><br>
    <input type="submit" value="Save"/>
</form>

<br> <br>
<c:if test="${message == true}">
    <h3>Category with the id ${category.id} was added!</h3>
</c:if>
<c:if test="${message == false}">
    <h3>You have errors! The category was not added!</h3>
</c:if>

</body>
</html>
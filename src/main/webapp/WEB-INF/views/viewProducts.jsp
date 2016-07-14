<%--
  Created by IntelliJ IDEA.
  User: florinani
  Date: 12/07/2016
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Products</title>
</head>
<body>

<c:if test="${not empty allProducts}">
    <h3>Products</h3>

    <table id="prodTable">
        <thead>
        <tr>
            <input type="checkbox" id="selectall"/> Select All </input>
        </tr>
        <tr>
            <th>Mark</th>
            <th>Product ID</th>
            <th>Code </th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${allProducts}">
            <tr>
                <td><input type="checkbox" id="idProd" class="check" value=${product.productId}></td>
                <td>${product.productId}</td>
                <td>${product.code}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.stockLevel}</td>
                <td><a href="<c:url value='edit/${product.productId}' />" ><input type="submit" value="Edit"></a></td>
                <td><a href="delete?productId=${product.productId}" methods="GET"><input type="submit" value="Delete"></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>

    <input type="submit" id="deleteButton" value="Delete selected"/>

</c:if>

<a href="add" methods="GET"><input type="submit" value="Create new product"></a>

<a href="export" methods="GET"><input type= "submit" value="Export Products to CSV"></a>

<br> <br>
<c:if test="${message == true}">
    <h3>Product deleted!</h3>
</c:if>

<form method="post" action="import" enctype="multipart/form-data">
    <table border="0">
        <tr>
            <td>Add file: </td>
            <td><input type="file" name="filename" size="50" accept=".csv"/></td>
        </tr>
        <tr>
            <td><input type="submit" id="importButton" value="Upload" /></td>
        </tr>
    </table>
</form>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<c:url var="jsUrl" value="/resources/js/myscript.js"/>
<script type="text/javascript" src="${jsUrl}"></script>

</body>
</html>

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

    <table>
        <thead>
        <tr>
            <th>Product ID</th>
            <th>Code </th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock Level</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${allProducts}">
            <tr>
                <td>${product.product_id}</td>
                <td>${product.code}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.stockLevel}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<a href="createProduct" methods="GET"><input type="submit" value="Create new product"></a>
<br>
<br>
<a href="exportproducts" methods="GET"><input type= "submit" value="Export Products to CSV"></a>

</body>
</html>

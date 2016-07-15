<%--
  Created by IntelliJ IDEA.
  User: mihaelarotarescu
  Date: 7/13/2016
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Export Products to CSV file</title>
</head>
<body>

<jsp:include page="backofficeHeader.jsp" />

<div class="row">
    <div class="col-md-3 col-md-offset-5">
        <h1>Exported Products</h1>
    </div>
</div>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <h3>All the products were exported to CSV</h3>
    </div>
</div>


<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <table  class="table table-striped">
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
            <c:forEach var="product" items="${export}">
                <tr>

                    <td>${product.productId}</td>
                    <td>${product.code}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>${product.stockLevel}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
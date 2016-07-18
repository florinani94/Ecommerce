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

<jsp:include page="backofficeHeader.jsp" />
<div class="row">
    <div class="col-md-2 col-md-offset-5">
    <c:if test="${not empty allProducts}">
        <h1>Products</h1>
    </div>
</div>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
    <table id="prodTable" class="table table-striped">
        <thead>
        <tr>
            <input type="checkbox" id="selectall"/> Select All
        </tr>
        <tr>
            <th></th>
            <th>ID</th>
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
                <td><a href="<c:url value='edit/${product.productId}' />" ><input type="submit" value="Edit" class="btn btn-primary"></a></td>
                <td><a href="<c:url value='/backoffice/product/delete?productId=${product.productId}'/>" methods="GET"><input type="submit" value="Delete" class="btn btn-danger"></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>

    <input type="submit" id="deleteButton" value="Delete selected" class="btn btn-default"/>

    </c:if>
        <c:url var="addProduct" value="/backoffice/product/add"/>
        <c:url var="exportProductas" value="/backoffice/product/export"/>
        <c:url var="importProductas" value="/backoffice/product/import"/>



    <a href="${addProduct}" methods="GET"><input type="submit" value="Create new product" class="btn btn-default"></a>

    <a href="${exportProductas}" methods="GET"><input type= "submit" value="Export Products to CSV" class="btn btn-default"></a>

    <br> <br>
    <c:if test="${result == true}">
        <h3>Product deleted!</h3>
    </c:if>
    </div>
</div>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form method="post" action="${importProductas}" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Add file: </td>
                    <td><input type="file" name="filename" size="50" accept=".csv"/></td>
                </tr>
                    <tr>
                        <br>
                        <td><input type="submit" id="importButton" value="Upload" class="btn btn-success"/></td>
                    </tr>
            </table>
        </form>
    </div>
</div>
<c:url var="jqueyUrl" value="/resources/jquery-1.8.3.js"/>
<script type="text/javascript" src="${jqueyUrl}"></script>

<c:url var="jsUrl" value="/resources/js/myscript.js"/>
<script type="text/javascript" src="${jsUrl}"></script>

</body>
</html>

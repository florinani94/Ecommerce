<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Create product</title>
</head>
<body>

<jsp:include page="backofficeHeader.jsp" />
<c:url var="newProdUrl" value="/backoffice/product/add"></c:url>
<c:url var="viewProdUrl" value="/backoffice/product"></c:url>

<h3> Create a new product </h3>
<c:if test="${result == null}">
    <form method="post" action="add" >
        <table>
            <tr>
                <td>Code</td>
                <td><input type="text" name="code" maxlength="8"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" maxlength="20"/></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" maxlength="255"/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td>Stock level</td>
                <td><input type="text" name="stockLevel"/></td>
            </tr>
        </table>

        <input type="submit" value="Add" class="btn btn-default"/>
    </form>
</c:if>


<c:if test="${result == true}">
    <h3>Product created with success!</h3>

    <a href="${newProdUrl}" class="btn btn-default" role="button">New product
    </a>

    <a href="${viewProdUrl}" class="btn btn-default" role="button">View products
    </a>
</c:if>

<c:if test="${result == false}">
    <h3>Product was not created!</h3>

    <a href="${newProdUrl}" class="btn btn-default" role="button">New product
    </a>
</c:if>

</body>
</html>

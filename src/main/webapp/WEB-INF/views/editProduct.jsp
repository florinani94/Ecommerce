<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <title>Update product</title>
</head>
<body>

<h3> Update product </h3>

<form method="put" action="editProduct" >
    <table>
        <tr>
            <td>ID</td>
            <td> <input type="text" name="productId" maxlength="8" value="${product.productId}" readonly /></td>
        </tr>
        <tr>
            <td>Code</td>
            <td><input type="text" name="code" maxlength="8" value="${product.code}"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" maxlength="20" value="${product.name}"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" maxlength="255" value="${product.description}"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${product.price}"/></td>
        </tr>
        <tr>
            <td>Stock level</td>
            <td><input type="text" name="stockLevel" value="${product.stockLevel}"/></td>
        </tr>
    </table>

    <input type="submit" value="Save"/>
</form>
</body>
</html>

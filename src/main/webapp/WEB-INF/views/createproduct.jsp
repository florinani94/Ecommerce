<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>

<h3> Create a new product </h3>

<form method="post" action="createproduct">
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

    <input type="submit" value="Save"/>
</form>


<c:if test="${message == true}">
    <h3>Prodact creted with success</h3>
</c:if>
<c:if test="${message == false}">
    <h3>Product was not created</h3>
</c:if>

</body>
</html>

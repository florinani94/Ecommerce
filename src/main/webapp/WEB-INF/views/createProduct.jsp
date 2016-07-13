<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>

<h3> Create a new product </h3>
<c:if test="${message == null}">
    <form method="post" action="createProduct" >
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
</c:if>


<c:if test="${message == true}">
    <h3>Product creted with success</h3>
    <form method="get" action="createProduct">
        <input type="submit" value="New product">
    </form>

    <form method="get" action="products">
        <input type="submit" value="View products">
    </form>

</c:if>
<c:if test="${message == false}">
    <h3>Product was not created</h3>
    <form method="get" action="createProduct">
        <input type="submit" value="New product">
    </form>
</c:if>

</body>
</html>

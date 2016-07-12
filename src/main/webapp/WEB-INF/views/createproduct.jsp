<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h3> Create a new product </h3>

<form mothod="post" action="">
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




</body>
</html>

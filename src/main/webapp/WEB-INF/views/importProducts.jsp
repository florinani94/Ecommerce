<%--
  Created by IntelliJ IDEA.
  User: dianamohanu
  Date: 13/07/2016
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Import</title>
</head>
<body>
<form method="post" action="import" enctype="multipart/form-data">
    <table border="0">
        <tr>
            <td>Add file: </td>
            <td><input type="file" name="filename" size="50" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Upload" /></td>
        </tr>
    </table>
</form>
</body>
</html>

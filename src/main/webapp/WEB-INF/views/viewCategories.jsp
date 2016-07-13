<%--
  Created by IntelliJ IDEA.
  User: mateimihai
  Date: 7/13/2016
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View categories</title>
</head>
<body>
<c:if test="${not empty allCategories}">
    <h3>Categories</h3>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <%--<th>Edit</th>--%>
                <%--<th>Delete</th>--%>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${allCategories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.description}</td>
                <%--<td><a href="<c:url value='/edit/${category.id}' />" >Edit</a></td>--%>
                <%--<td><a href="<c:url value='/delete/${category.id}' />" >Delete</a></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Order Details</title>
</head>
<body>
    <h1>The Orders</h1>

    <h1>${orderDetails.email}</h1>

    <c:forEach var="entry" items="${entries}" >
        ${entry.productName}
    </c:forEach>

</body>
</html>

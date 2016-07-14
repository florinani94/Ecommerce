<%--
  Created by IntelliJ IDEA.
  User: florinani
  Date: 12/07/2016
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:url var="cssUrl" value="/resources/style/PaginatorStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrl}">

    <title>Products</title>
        </head>
            <body>

                <c:if test="${not empty products}">

                    <div id="container">
                            <c:forEach var="product" items="${products}">
                                <div class="square">
                                    <ul>
                                        <li>Code: ${product.code} </li>
                                        <li>Name: ${product.name} </li>
                                        <li>Description: ${product.description} </li>
                                        <li>Price: ${product.price}</li>
                                        <li>StockLevel: ${product.stockLevel}</li>
                                    </ul>
                                </div>
                            </c:forEach>
                    </div>

                </c:if>

    <c:set var="nrPages" value="${productSize div 9}"/>

    <br>
    <c:set var="dateParts" value="${fn:split(nrPages, '.')}" />

    <c:set var="nrPagesInt" value="${dateParts[0]}" ></c:set>

    <c:if test="${dateParts[1]!=\"0\"}">
        <c:set var="nrPagesInt" value="${nrPagesInt+1}"/>
    </c:if>

    <c:forEach var="i" begin="1" end="${nrPagesInt}">
        <a href= "/mvc/customer/products?page=${i}" methods="GET"><input type="submit" value="${i}"></a>
    </c:forEach>

</body>
</html>

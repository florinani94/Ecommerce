<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:url var="cssUrl" value="/resources/style/PaginatorStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrl}">

    <c:url var="bkgURL2" value="/resources/background2.jpg"></c:url>

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <title>Products</title>
</head>

<body style="background-image:url(${bkgURL2});background-repeat: no-repeat; background-size: 100%; )">

    <div class="row">
        <div class="col-md-3 col-md-offset-5">
            <h1><b>Our Products</b></h1>
        </div>
        <div class="col-md-2 col-md-offset-1" style="margin-top: 1%">
            <form method="get" action="/mvc/products?page=${currentPage-1}&sortValue=${sortValue}">
                <select name="sortValue" id="sort">
                    <option value="none">Sort By</option>
                    <option value="sortpriceupdown">Price Cheap to Expensive</option>
                    <option value="sortpricedownup">Price Expensive to Cheap</option>
                    <option value="sortnameaz">Name A to Z</option>
                    <option value="sortnameza">Name Z to A</option>
                </select>
                <input type="submit" value="Sort"/></td>
            </form>
        </div>
    </div>
    <c:if test="${not empty products}">

        <div class="container">
            <c:forEach var="product" items="${products}">
                <div class="square">
                    <ul>
                        <br>

                        <li>Code: ${product.code} </li>
                        <li>Name: ${product.name} </li>
                        <li>Description: ${product.description} </li>
                        <li>Price: ${product.price}</li>
                        <li>StockLevel: ${product.stockLevel}</li>

                        <br>

                        <c:if test="${product.stockLevel gt 0}">
                            <span class="label label-success">In stock!</span>
                        </c:if>
                        <c:if test="${product.stockLevel lt 1}">
                            <span class="label label-warning">Out of stock!</span>
                        </c:if>
                    </ul>
                </div>
            </c:forEach>
        </div>

    </c:if>

    <c:set var="nrPages" value="${productSize div 9}"/>
    <c:set var="dateParts" value="${fn:split(nrPages, '.')}" />
    <c:set var="nrPagesInt" value="${dateParts[0]}" ></c:set>

    <c:if test="${dateParts[1]!=\"0\"}">
        <c:set var="nrPagesInt" value="${nrPagesInt+1}"/>
    </c:if>

    <div class="paginationView">
        <c:if test="${currentPage>1}">
            <a href="<c:url value='/products?page=${1}&sortValue=${sortValue}'/>" methods="GET">1</a>
        </c:if>
        <c:if test="${currentPage-1 >1}">
            ...
        </c:if>
        <c:if test="${currentPage!=1 && currentPage-1!=1}">
            <a href="<c:url value='/products?page=${currentPage-1}&sortValue=${sortValue}'/>" methods="GET">${currentPage-1}</a>
        </c:if>
        <a href="<c:url value='/products?page=${currentPage}&sortValue=${sortValue}'/>" methods="GET">${currentPage}</a>

        <c:if test="${currentPage <nrPagesInt-1}">
            <a href="<c:url value='/products?page=${currentPage+1}&sortValue=${sortValue}'/>" methods="GET">${currentPage+1}</a>
        </c:if>
        <c:if test="${currentPage+1 <nrPagesInt-1}">
            ...
        </c:if>
        <c:if test="${currentPage!=nrPagesInt}">
            <a href="<c:url value='/products?page=${nrPagesInt}&sortValue=${sortValue}'/>" methods="GET">${nrPagesInt}</a>
        </c:if>
    </div>

</body>
</html>

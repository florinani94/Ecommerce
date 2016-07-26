<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <c:url var="cssUrl" value="/resources/style/PaginatorStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrl}">

    <c:url var="cssUrlHead" value="/resources/style/detailViewStyle.css"></c:url>
    <link rel="stylesheet" type="text/css" href="${cssUrlHead}">

    <c:url var="bkgURL2" value="/resources/detailView/Background2.jpg"></c:url>

    <title>Order Details</title>
</head>
<body style="background-image:url(${bkgURL2});background-repeat: no-repeat; background-size: 130%; )">

    <jsp:include page="customerHeader.jsp" />


    <div class="container">

        <div class="row">
            <div class="col-md-3 col-md-offset-5">
                <h2>Order Details</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">

                <c:if test="${orderDetails.status eq 'delivered'}">
                    <h3>The order's status is: <span class="label label-success">${orderDetails.status}</span></h3>
                </c:if>

                <c:if test="${orderDetails.status eq 'processing'}">
                    <h3>The order's status is: <span class="label label-warning">${orderDetails.status}</span></h3>
                </c:if>

                <c:if test="${orderDetails.status eq 'rejected'}">
                    <h3>The order's status is: <span class="label label-danger">${orderDetails.status}</span></h3>
                </c:if>

                <h3>Products</h3>
                <table class="table" style="background-color: white">
                    <tr>
                        <th>Quantity</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                    <c:forEach var="entry" items="${entries}" >
                        <tr>
                            <td>${entry.quantity}</td>
                            <td>${entry.productCode}</td>
                            <td>${entry.productName}</td>
                            <td>${entry.subTotal}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

    </div>


    <jsp:include page="customerFooter.jsp"/>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <c:url var="cssUrl" value="/resources/style/ProjectStyle.css"/>
    <c:url var="listURL" value="/backoffice/product/"/>
    <c:url var="importURL" value="/backoffice/product/import"/>
    <c:url var="exportURL" value="/backoffice/product/export"/>
    <c:url var="addURL" value="/backoffice/product/add"/>
    <c:url var="listCategoryURL" value="/backoffice/category/"/>
    <c:url var="createCategoryURL" value="/backoffice/category/add"/>


    <link rel="stylesheet" type="text/css" href="${cssUrl}">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

    <script
            src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <title>Home</title>
</head>
<body>
<header>

    <div class="row back">
        <div class = "col-md-6">
            <h2 class = "bigTitle">Tea Shop Back Office</h2>
        </div>

        <div class = "col-md-6">
            <ul>
                <li><a href="${createCategoryURL}">Create category</a></li>
                <li><a href="${listCategoryURL}">View categories</a></li>
                <li><a href="${exportURL}">Export teas to file</a></li>
                <li><a href="${addURL}">Create product</a></li>
                <li><a href="${listURL}">View products</a></li>
            </ul>
        </div>
    </div>


</header>
</body>
</html>

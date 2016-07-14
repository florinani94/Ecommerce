<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
     <c:url var="cssUrl" value="/resources/style/ProjectStyle.css"></c:url>

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
                <li><a href="import">Import teas from file </a></li>
                <li><a href="export">Export teas to file</a></li>
                <li><a href="add">Create Product</a></li>
                <li><a href="product/">View Products</a></li>
            </ul>
        </div>
    </div>


</header>
</body>
</html>

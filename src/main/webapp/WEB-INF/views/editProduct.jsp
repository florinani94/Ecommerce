<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Update product</title>

    <%--TODO put this into a file and include it here--%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

    <script
            src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <style type="text/css">
        .layout-edit {
            margin: 40px;
        }

        .form-control {
            width: 800px;
        }
        .page-header{
            text-align: left;
            margin: 40px;
        }
    </style>

</head>
<body>

<c:url var="editUrl" value="/backoffice/editProduct"/>

<div class="page-header"><h1> Update Product </h1></div>

<div class="layout-edit">

    <form:form commandName="product" method="POST" action="${editUrl}" cssClass="form-horizontal registrationForm">

        <div class="form-group">
            <label for="product_id" class="control-label col-xs-2">ID: </label>
            <div class="col-sm-10">
                <form:input path="product_id" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="code" class="control-label col-xs-2">Code: </label>
            <div class="col-xs-10">
                <form:input path="code" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="control-label col-xs-2">Name: </label>
            <div class="col-xs-10">
                <form:input path="name" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="control-label col-xs-2">Description: </label>
            <div class="col-xs-10">
                <form:input path="description" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="control-label col-xs-2">Price: </label>
            <div class="col-xs-10">
                <form:input path="price" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="stockLevel" class="col-sm-2 control-label">Stock: </label>
            <div class="col-xs-10">
                <form:input path="stockLevel" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>

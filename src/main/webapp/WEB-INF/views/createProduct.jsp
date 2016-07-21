
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Create product</title>

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

        .form-control {
            width: 100px;

        }

        .page-header {
            text-align: left;
            margin: 40px;
        }
    </style>


    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>

</head>
<body>

<jsp:include page="backofficeHeader.jsp" />

<c:url var="newProdUrl" value="/backoffice/product/add"></c:url>
<c:url var="viewProdUrl" value="/backoffice/product"></c:url>
<c:url var="javaScriptUrl" value="/resources/js/myscript.js"></c:url>

<div class="page-header"><h1> Create Product </h1></div>

<div class="container">
    <form:form commandName="product" method="POST" action="add" cssClass="form-horizontal registrationForm" enctype="multipart/form-data">
        <div class="row">
            <div class= "form-group col-lg-5">
                <label for="code" class="control-label col-xs-2">Code: </label>
                <div class="col-xs-10">
                    <form:input  path="code" maxlength="8" cssClass="form-control"/>
                    <form:errors path="code" cssClass="error" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class= "form-group col-lg-5">
                <label for="name" class="control-label col-xs-2">Name: </label>
                <div class="col-xs-10">
                    <form:input  path="name" maxlength="200" cssClass="form-control"/>
                    <form:errors path="name"  cssClass="error" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class= "form-group col-lg-5">
                <label for="description" class="control-label col-xs-2">Description: </label>
                <div class="col-xs-10">
                    <form:textarea path="description" rows="4" cols="50"  maxlength="255" form="addProd" cssClass="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class= "form-group col-lg-5">
                <label for="price" class="control-label col-xs-2">Price: </label>
                <div class="col-xs-10">
                    <form:input type="number" path="price" cssClass="form-control"/>
                    <form:errors path="price"  cssClass="error" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class= "form-group col-lg-5">
                <label for="stockLevel" class="col-sm-2 control-label">Stock: </label>
                <div class="col-xs-10">
                    <form:input type="number" path="stockLevel" cssClass="form-control"/>
                    <form:errors path="stockLevel" cssClass="error" />
                </div>
            </div>
        </div>
        <div class="row">
            <div class= "form-group col-lg-5">
                <div class="col-xs-offset-2 col-xs-10">
                    <b>Select a image (.jpg)</b> <br><br>
                    <input  name="image" type="file" accept=".jpg"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class= "form-group col-lg-5">
                <div class="col-xs-offset-2 col-xs-10">
                    <b>Choose a category:</b> <br><br>
                    <select name="categoryId" id="dropDown">
                        <c:forEach var="categoryItem" items="${allCategories}">
                            <option value="${categoryItem.id}">${categoryItem.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class= "form-group col-lg-5">
                <div class="col-xs-offset-2 col-xs-10">
                    <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
                </div>
            </div>
        </div>
    </form:form>
</div>

<script type="application/javascript" src="${javaScriptUrl}"></script>

</body>
</html>


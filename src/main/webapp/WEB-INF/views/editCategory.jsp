<%--
  Created by IntelliJ IDEA.
  User: biancavalean
  Date: 7/21/2016
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update category</title>

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

<c:url var="editUrl" value="/backoffice/category/edit"/>

<div class="page-header"><h1> Update Category </h1></div>

<div class="layout-edit">

    <c:url var="editUrl" value="/backoffice/category/edit"></c:url>

    <form:form commandName="category" method="POST" action="${editUrl}" cssClass="form-horizontal registrationForm">
        <div class="form-group">
            <label for="id" class="control-label col-xs-2">ID: </label>
            <div class="col-sm-10">
                <form:input readonly="true" path="id" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="name" class="control-label col-xs-2">Name: </label>
            <div class="col-sm-10">
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name"  cssClass="error" />
            </div>
        </div>

        <div class="form-group">
            <label for="description" class="control-label col-xs-2">Description: </label>
            <div class="col-sm-10">
                <form:input path="description" cssClass="form-control"/>
                <form:errors path="description"  cssClass="error" />
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
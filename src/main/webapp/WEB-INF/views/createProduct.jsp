<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>

<c:url var="newProdUrl" value="/backoffice/product/add"></c:url>
<c:url var="viewProdUrl" value="/backoffice/product/"></c:url>


<jsp:include page="backofficeHeader.jsp" />
<div class="row">
    <div class="col-md-3 col-md-offset-4" style="text-align: center">
        <h1> Create a new product </h1>
        <br>
    </div>
</div>

<c:if test="${result == null}">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
                <form action="add" method="post" id="addProd" class="form-inline" enctype="multipart/form-data">
                    Code: <br>
                    <input type="text" name="code" maxlength="8" class="form-control"/>
                    <br><br>
                    Name: <br>
                    <input type="text" name="name" maxlength="20" class="form-control"/>
                    <br><br>
                    Description: <br>
                    <textarea rows="4" cols="50" name="description" maxlength="255" form="addProd" class="form-control"></textarea>
                    <br><br>
                    Price: <br>
                    <input type="text" name="price" class="form-control"/>
                    <br><br>
                    Stock level: <br>
                    <input type="text" name="stockLevel" class="form-control"/>
                    <br><br>
                    Select a image (.jpg) <br>
                    <input name="image" type="file" accept=".jpg"/>
                    <br><br>
                    <input type="submit" value="Save" class="btn btn-success"/>
                </form>
        </div>
    </div>
</c:if>


<c:if test="${result == true}">
    <div class="row">
        <div class="col-md-3 col-md-offset-4">
            <h3 style="text-align: center">Product created with success!</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1 col-md-offset-4">
            <a href="${newProdUrl}" class="btn btn-default" role="button">New product</a>
        </div>
        <div class="col-md-1 col-md-offset-1">
            <a href="${viewProdUrl}" class="btn btn-default" role="button">View products</a>
        </div>
    </div>
</c:if>

<c:if test="${result == false}">
<div class="row">
    <div class="col-md-3 col-md-offset-4">
        <h3 style="text-align: center">Product was not created!</h3>
    </div>
</div>
<div class="row">
    <div class="col-md-2 col-md-offset-5">
        <a href="${newProdUrl}" class="btn btn-default" role="button">New product
        </a>
    </div>
</div>

</c:if>

</body>
</html>

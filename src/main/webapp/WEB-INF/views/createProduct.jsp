<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Create product</title>

    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>

</head>
<body>

<c:url var="newProdUrl" value="/backoffice/product/add"></c:url>
<c:url var="viewProdUrl" value="/backoffice/product"></c:url>


<jsp:include page="backofficeHeader.jsp" />
<div class="row">
    <div class="col-md-3 col-md-offset-4" style="text-align: center">
        <h1> Create a new product </h1>
        <br>
    </div>
</div>

    <div class="row">
        <div class="col-md-4 col-md-offset-4">
                <form  action="add" method="post" id="addProd" class="form-inline" enctype="multipart/form-data">
                    Code: <br>
                    <input type="text" name="code" maxlength="8" class="form-control"/>
                    <spring form:errors path="code" class="error"/>
                    <br><br>
                    Name: <br>
                    <input id="nameId" type="text" name="name" maxlength="20" class="form-control"/>
                    <spring form:errors path="name" class="error"/>
                    <br><br>
                    Description: <br>
                    <textarea type ="text" rows="4" cols="50" name="description" maxlength="255" form="addProd" class="form-control"></textarea>
                    <br><br>
                    Price: <br>
                    <input type="number" name="price" class="form-control"/>
                    <spring form:errors path="price" class="error"/>
                    <%--<input type="text" name="price" class="form-control"/>--%>
                    <br><br>
                    Stock level: <br>
                    <input  type="number" name="stockLevel" class="form-control"/>
                    <spring form:errors path="stockLevel" class="error" />
                    <%--<input type="text" name="stockLevel" class="form-control"/>--%>
                    <br><br>
                    Select a image (.jpg) <br>
                    <input name="image" type="file" accept=".jpg"/>
                    <br><br>
                    <input type="submit" value="Save" class="btn btn-success"/>
                </form>
        </div>
    </div>

</body>
</html>

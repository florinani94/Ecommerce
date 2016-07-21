<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>

<c:url var="newProdUrl" value="/backoffice/product/add"></c:url>
<c:url var="viewProdUrl" value="/backoffice/product"></c:url>
<c:url var="javaScriptUrl" value="/resources/js/myscript.js"></c:url>


<jsp:include page="backofficeHeader.jsp" />
<div class="row">
    <div class="col-md-4 col-md-offset-4">
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
                    <p><b>Choose a category:</b></p>
                    <select name="categoryId" id="dropDown">
                        <c:forEach var="categoryItem" items="${allCategories}">
                            <option value="${categoryItem.id}">${categoryItem.name}</option>
                        </c:forEach>
                    </select>
                    <br><br>
                    <br>
                    <input name="image" type="file" accept=".jpg"/>
                    <br><br>
                    <%--<script type="text/javascript" src="/mvc/resources/jquery-1.8.3.js"></script>--%>
                    <%--<script type="text/javascript" src="/mvc/resources/js/SetCategory.js"></script>--%>
                    <%--<div class="setCategory" style="display: none" name="category"></div>--%>
                    <input type="submit" value="Save" class="btn btn-success" id="addProductButton"/>
                </form>
        </div>
    </div>
</c:if>


<c:if test="${result == true}">
    <h3>Product created with success!</h3>

    <a href="${newProdUrl}" class="btn btn-default" role="button">New product
    </a>

    <a href="${viewProdUrl}" class="btn btn-default" role="button">View products
    </a>
</c:if>

<c:if test="${result == false}">
    <h3>Product was not created!</h3>

    <a href="${newProdUrl}" class="btn btn-default" role="button">New product
    </a>
</c:if>

<script type="application/javascript" src="${javaScriptUrl}"></script>

</body>
</html>

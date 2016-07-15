<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>

<jsp:include page="backofficeHeader.jsp" />
<div class="row">
    <div class="col-md-2 col-md-offset-5">
        <h3> Create a new product </h3>
        <br>
    </div>
</div>
<c:if test="${result == null}">
    <div class="row">
        <div class="col-md-2 col-md-offset-5">
            <form method="post" action="add" class="form-inline">
                <table>
                    <tr>
                        <td>Code</td>
                        <td><input type="text" name="code" maxlength="8" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" maxlength="20" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="description" maxlength="255" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="price" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>Stock level</td>
                        <td><input type="text" name="stockLevel" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save" class="btn btn-success"/></td>
                    </tr>
                </table>

            </form>
        </div>
    </div>
</c:if>


<c:if test="${result == true}">
    <h3>Product created with success</h3>
    <form method="get" action="add">
        <input type="submit" value="New product">
    </form>

    <form method="get" action="*">
        <input type="submit" value="View products">
    </form>

</c:if>
<c:if test="${result == false}">
    <h3>Product was not created</h3>
    <form method="get" action="add">
        <input type="submit" value="New product">
    </form>
</c:if>

</body>
</html>

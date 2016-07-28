<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quartz Job</title>
</head>
<body>
<div class = "row">
    <div class="col-md-3 col-md-offset-3">
        <h1>${msg}</h1>
        <form:form action="job" method="post">
            <input type="submit" value="Start/Stop job">
        </form:form>
    </div>
</div>

<br>
<br>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <a href="<c:url value='/backoffice/product/' />">Back to Products</a>
    </div>
</div>

</body>
</html>
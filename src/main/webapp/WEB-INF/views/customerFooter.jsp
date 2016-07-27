<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="cartJavaScriptUrl" value="/resources/js/cartBehaviour.js"></c:url>
<%--todo: create a css.tag and js. tag and move these files--%>
    <link rel="stylesheet" href="/resources/style/detailViewStyle.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    <footer class="footer">
        <div class="row">
            <div class="col-md-3 col-md-offset-5">
                <a class="footerLink" href="/mvc/products"> Products </a>
                <a class="footerLink"> Terms and Conditions </a>
                <a class="footerLink"> Contact </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-md-offset-5">
                <p class="footerText">@Java Internship Summer 2016</p>
            </div>
        </div>
    </footer>

<script src="/mvc/resources/jquery-1.8.3.js"></script>
<script type="application/javascript" src="${cartJavaScriptUrl}"></script>

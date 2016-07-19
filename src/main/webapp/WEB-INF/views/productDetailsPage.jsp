<%--
  Created by IntelliJ IDEA.
  User: mateimihai
  Date: 7/18/2016
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="bkgURL" value="/resources/background2.jpg"/>

<html>
<head>
    <link rel="stylesheet" href="detailViewStyle.css">
    <title>${theProduct.name}</title>

</head>
<body>
<jsp:include page="backofficeHeader.jsp" />
<table class="pageLayout" id="productLayout" border="0">
    <tr>
        <td id="imageCell"><img src="SimpleLogo.png"></img></td>
        <td id="spaceCol"></td>
        <td id="productDetails"><h1 class="pageText" id="productTitle">Product no. 1</h1>
            <table border="0" class="detailsText">
                <tr><td>Description:</td>
                </tr>
                <tr><td>Our tea, the best tea. Probably the bes tea in the world. Buddies know why.</td>
                </tr>
                <tr><td id="spaceRow"></td>
                </tr>
                <tr><td>Categories:</td>
                </tr>
                <tr><td>Green, Fruit, Summer.</td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: csing
  Date: 4/30/2019
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <c:forEach items="${initProdList}" var="anItem" varStatus="loopCounter">
        <td>
            <form action="products" method="post">
                <input type="hidden" name="action" value="add">
                <p align="center">
                    <input type="hidden" name="item" value='<c:out value="${anItem.prodID}"/>'>
                    <input type="text" name="prodid" value='<c:out value="${anItem.prodID}"/>'><br>
                    <input type="hidden" name="prodidh" value='<c:out value="${anItem.prodID}"/>'><br>
                    <input type="text" name="prodname" value='<c:out value="${anItem.prodName}"/>'><br>
                    <input type="hidden" name="prodnameh" value='<c:out value="${anItem.prodName}"/>'><br>
                    <input type="text" name="proddesc" value='<c:out value="${anItem.prodDesc}"/>'><br>
                    <input type="hidden" name="proddesch" value='<c:out value="${anItem.prodDesc}"/>'><br>
                    <input type="text" name="prodprice" value='<fmt:formatNumber value="${anItem.prodPrice}" type="currency" currencyCode="USD" />'><br>
                    <input type="hidden" name="prodpriceh" value='<c:out value="${anItem.prodPrice}"/>'><br>
                    <img src="<c:out value="${anItem.prodPicLocation}"/>" height="175" width="175" alt=""><br>
                    <input type="hidden" name="prodpich" value='<c:out value="${anItem.prodPicLocation}"/>'>
                    <input type="hidden" name="prodquanth" value='<c:out value="${anItem.prodQuant}"/>'>
                    <input type="submit" value="Add">
                </p>
            </form>
        </td>

        <c:if test="${loopCounter.count % 5 == 0}">
    <tr></tr>
    </c:if>

    </c:forEach>
    </tr>

    <tr>
        <td colspan="5">
            <p align="center">
                <c:choose>
                <c:when test="${aCart.theCart.size() == null}">
                You have 0 items in your current cart!
                </c:when>
                <c:otherwise>
                You have <c:out value="${aCart.theCart.size()}"></c:out> different items in your cart!
                </c:otherwise>
                </c:choose>
            <form method="post" action="products">
                <input type="hidden" name="action" value="checkout">
                <input type="submit" value="Checkout" align="center">

            </form>
            </p>
        </td>
    </tr>

</table>

</body>
</html>

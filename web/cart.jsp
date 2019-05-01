<%--
  Created by IntelliJ IDEA.
  User: csing
  Date: 4/30/2019
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <th>Quantity</th>
    <th>Item Id</th>
    <th>Image</th>
    <th>Product Name</th>
    <th>Description</th>
    <th>Price Per Item</th>
    <th>Total to pay per item</th>
    <c:set var="total" value="${0}"></c:set>
    <c:forEach var="prod" items="${aCart.theCart}">
        <tr>
            <td>
                <form method="post" action="products">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="prodID" value='<c:out value="${prod.prodID}"></c:out>'>
                    <input type="number" name="prodQuant" value='<c:out value="${prod.prodQuant}"></c:out>'>
                    <input type="submit" value="Update">
                </form>
            </td>
            <td><c:out value="${prod.prodID}"></c:out></td>
            <td><img src="<c:out value="${prod.prodPicLocation}"/>" height="75" width="75" alt=""></td>
            <td><c:out value="${prod.prodName}"></c:out></td>
            <td><c:out value="${prod.prodDesc}"></c:out></td>
            <td><c:out value="${prod.prodPrice}"></c:out></td>
            <td><c:out value="${prod.prodQuant * prod.prodPrice}"></c:out></td>
            <c:set var="total" value="${total + prod.prodQuant * prod.prodPrice}"></c:set>
        </tr>
    </c:forEach>

    <tr><td colspan="5">Total Payment is $<fmt:formatNumber type="number" minFractionDigits="2"><c:out value="${total}"></c:out> </fmt:formatNumber> </td> </tr>
    <tr><td colspan="5">

        <form action="products.jsp" method="post">
            <input type="submit"  value="Continue Shopping">
        </form>

        <form method="post" action="products">
            <input type="submit" value="Checkout Payment">
        </form>
    </td></tr>

</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 28.03.2020
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.time.LocalDateTime"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
    <h2>Cart</h2>
    <%@include file="menu.jsp"%>
    <p><%=LocalDateTime.now().toString()%></p>
    <table border = "1">
        <tr>
            <th>product</th>
            <th>price $/kg</th>
            <th>sum $</th>
        </tr>
        <c:if test="${orders.size()!=0}">
            <c:forEach items="${orders}" var = "order">
                <tr>
                    <td>${order.name} </td>
                    <td>${order.price} </td>
                    <td>${order.count} </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 20.03.2020
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<ul style="list-style-type: none">
    <li style="display: inline-block"><a href="${pageContext.request.contextPath}/">Main</a></li>
    <li style="display: inline-block"><a href="${pageContext.request.contextPath}/catalog">Catalog</a></li>
    <li style="display: inline-block"><a href="${pageContext.request.contextPath}/order">Order</a></li>
    <li style="display: inline-block"><a href="${pageContext.request.contextPath}/product">Product</a></li>
    <li style="display: inline-block"><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
</ul>
</body>
</html>

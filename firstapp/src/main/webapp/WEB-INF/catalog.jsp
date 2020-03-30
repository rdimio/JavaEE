<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 28.03.2020
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
    <h2>Catalog</h2>
    <%@include file="menu.jsp"%>
     <table border = "1">
         <tr>
             <th>product</th>
             <th>price $/kg</th>
         </tr>
         <jsp:useBean id="productList" scope="request" class="ru.geekbrains.persist.ProductList"/>
         <c:if test="${productList.products.size()!=0}">
            <c:forEach items="${productList.products}" var = "prod">
                <tr>
                    <td>${prod.name} </td>
                    <td>${prod.price} </td>
                </tr>
            </c:forEach>
         </c:if>
     </table>
    <br>
    <c:url value="/product" var="products"/>
    <a href="${products}">Description of products</a>
    </br>
</body>
</html>

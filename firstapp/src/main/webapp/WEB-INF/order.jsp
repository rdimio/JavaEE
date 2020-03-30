<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 28.03.2020
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
    <h2>Order</h2>
    <%@include file="menu.jsp"%>
    <form action="cart" method="GET">
        <table border="0">
            <tbody>

            <tr>
                <td> Choose the product</td>
                <td>
                    <select name="id">
                        <option>Apple</option>
                        <option>Banana</option>
                        <option>Orange</option>
                        <option>Potato</option>
                        <option>Tomato</option>
                        <option>Strawberry</option>
                        <option>Pineapple</option>
                        <option>Grape</option>
                        <option>Cucumber</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Inter the sum in kg: </td>
                <td><input type="text" name="num" value="" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add in cart"></td>
            </tr>
            </tbody>
        </table>
    </form>
    <br>
    <c:url value="/cart" var="cart"/>
    <a href="${cart}">Go to cart!</a>
    </br>
</body>
</html>

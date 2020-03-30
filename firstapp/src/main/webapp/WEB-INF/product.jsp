<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 28.03.2020
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
    <h2>Product</h2>
    <%@include file="menu.jsp"%>
    <c:url value="https://www.pexels.com/photo/apple-blur-bright-close-up-588587/" var="apple"/>
    <a href="${apple}">Apple</a>

    <br>
    <c:url value="https://newkuban.ru/news/06127902/" var="banana"/>
    <a href="${banana}">Banana</a>
    </br>

    <c:url value="https://www.agriculturenigeria.com/production/orange-production/" var="orange"/>
    <a href="${orange}">Orange</a>

    <br>
    <c:url value="https://time.com/3574780/usda-potato-genetically-engineered/" var="potato"/>
    <a href="${potato}">Potato</a>
    </br>

    <c:url value="https://bgr.com/2019/05/14/tomato-flavor-nature-study-genetics/" var="tomato"/>
    <a href="${tomato}">Tomato</a>

    <br>
    <c:url value="https://www.banggood.com/100Pcs-Giant-Red-Strawberry-Seeds-Rarest-Heirloom-Super-Giant-Japan-Strawber-Seeds-Garden-p-1117678.html?cur_warehouse=CN" var="strawberry"/>
    <a href="${strawberry}">Strawberry</a>
    </br>

    <c:url value="https://unsplash.com/s/photos/pineapple" var="pineapple"/>
    <a href="${pineapple}">Pineapple</a>

    <br>
    <c:url value="https://unsplash.com/s/photos/grape" var="grape"/>
    <a href="${grape}">Grape</a>
    </br>

    <c:url value="https://unsplash.com/s/photos/cucumber" var="cucumber"/>
    <a href="${cucumber}">Cucumber</a>
</body>
</html>

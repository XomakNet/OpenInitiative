<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 01.07.2015
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Категории инициатив</h1>
<table class="table">
    <c:forEach items="${categories}" var="category">

        <c:url value="${pageContext.request.contextPath}/delete" var="deleteURL">
            <c:param name="id"   value="${category.id}" />
        </c:url>
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>
                <c:url value="/category/${category.id}/edit" var="editURL"/>
                <a href="${editURL}" class="btn btn-success">Изменить</a>
                <c:url value="/category/${category.id}/delete" var="deleteURL"/>
                <a href="${deleteURL}" class="btn btn-danger">Удалить</a>
            </td>
        </tr>
    </c:forEach>
    <c:url value="/category/new" var="createURL"/>
    <a href="${createURL}" class="btn btn-success">Создать</a>
</table>

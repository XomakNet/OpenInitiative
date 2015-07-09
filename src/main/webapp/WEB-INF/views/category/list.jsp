<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 01.07.2015
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <c:url value="/category/new" var="createURL"/>
        <h1>Категории инициатив <a href="${createURL}" class="btn btn-success">Создать</a></h1>
    </div>
    <div class="row">
        <table class="table">
            <c:forEach items="${categories}" var="category">

                <c:url value="${pageContext.request.contextPath}/delete" var="deleteURL">
                    <c:param name="id" value="${category.id}"/>
                </c:url>
                <c:if test="${!category.isActive}">
                    <c:set var="rowClass" value="danger"/>
                </c:if>
                <tr class="${rowClass}">
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                    <td>
                        <c:url value="/category/${category.id}/edit" var="editURL"/>
                        <a href="${editURL}" class="btn btn-success">Изменить</a>
                        <c:url value="/category/${category.id}/delete" var="deleteURL"/>
                        <a href="${deleteURL}" class="btn btn-danger">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
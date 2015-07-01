<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 01.07.2015
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>
<c:choose>
    <c:when test="${category.id > 0}">
        Редактирование категории
    </c:when>
    <c:otherwise>
        Новая категория
    </c:otherwise>
</c:choose>
    </h1>
<form:form modelAttribute="category" action="" id="categoryForm" method="post">
    <form:errors path="*" cssClass="alert alert-error"/>
    <form:label path="name">
        Название
    </form:label>
    <form:input path="name" />
    <input type="submit" class="btn btn-success" value="Сохранить" />
</form:form>


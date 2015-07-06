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



<div class="container">
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
        <div class="row">
            <form:label path="name">
                Название
            </form:label>
            <form:input path="name"/>
            <form:errors path="name" cssClass="alert alert-danger"/>
        </div>
        <div class="row">
            <form:label path="description">
                Описание
            </form:label>
        </div>
        <div class="row">
            <form:textarea path="description" rows="10" cols="20"/>
            <form:errors path="description" cssClass="alert alert-danger"/>
        </div>
        <div class="row">
            <form:label path="isActive">
                Активна
            </form:label>
            <form:checkbox path="isActive"/>
            <form:errors path="isActive" cssClass="alert alert-danger"/>
        </div>
        <div class="row">
            <c:url value="/category/" var="cancelURL"/>
            <a href="${cancelURL}" class="btn btn-danger">Отмена</a>
            <input type="submit" class="btn btn-success" value="Сохранить"/>
        </div>
    </form:form>
</div>


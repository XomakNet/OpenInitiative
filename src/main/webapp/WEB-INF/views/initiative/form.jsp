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
            Новая инициатива
</h1>
${initiative}
<div class="container">
    <form:form modelAttribute="initiative" action="" id="initiativeForm" method="post">
        <div class="row">
            <form:label path="name">
                Название
            </form:label>
            <form:input path="name"/>
            <form:errors path="name" cssClass="alert alert-danger"/>
        </div>
        <div class="row">
            <form:label path="description">
                Краткое описание
            </form:label>
        </div>
        <div class="row">
            <form:textarea path="description" rows="10" cols="20"/>
            <form:errors path="description" cssClass="alert alert-danger"/>
        </div>
        <div class="row">
            <form:label path="text">
                Полный текст инициативы
            </form:label>
        </div>
        <div class="row">
            <form:textarea path="text" rows="50" cols="190"/>
            <form:errors path="text" cssClass="alert alert-danger"/>
        </div>
        <div class="row">
            <form:label path="categories">
                Категории
            </form:label>
            <form:select path="categories" items="${categories}" itemValue="id" itemLabel="name"/>
            <form:errors path="categories" cssClass="alert alert-danger"/>
        </div>
        <div class="row">
            <input type="submit" class="btn btn-success" value="Создать"/>
        </div>
    </form:form>
</div>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 03.07.2015
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--TODO: Replace to styles--%>
<style>
    .authForm {
        max-width: 500px;
    }
    /*TODO: Change this to class no-bottom-round, top*/
    .authForm input[type="text"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .authForm input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>
<div class="container authForm">
    <h2>Авторизация</h2>
    ${messageTest}
    <c:if test="${message != null}">
        <div class="panel ${message.cssClass}">
            <div class="panel-heading">
                <h3 class="panel-title">${message.title}</h3>
            </div>
            <div class="panel-body">
                    ${message.message}
            </div>
        </div>
    </c:if>

    <form:form modelAttribute="authFormData" action="" id="initiativeForm" method="post" cssClass="form-horizontal">

        <form:label path="login" cssClass="sr-only">Название</form:label>
        <form:input path="login" cssClass="form-control input-lg" placeholder="Логин"/>
        <form:label path="password" cssClass="sr-only">Пароль</form:label>
        <form:password path="password" cssClass="form-control input-lg" placeholder="Пароль"/>
        <form:hidden path="returnURL"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form:form>

</div>
<!-- /container -->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 03.07.2015
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .authForm {
        max-width: 500px;
    }
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
    <div class="panel panel-danger">
        <div class="panel-heading">
            <h3 class="panel-title">Авторизация не удалась</h3>
        </div>
        <div class="panel-body">
            Вы ввели неправильный логин или пароль.
        </div>
    </div>
    <form:form modelAttribute="authFormData" action="" id="initiativeForm" method="post" cssClass="form-horizontal">

        <form:label path="login" cssClass="sr-only">Название</form:label>
        <form:input path="login" cssClass="form-control input-lg" placeholder="Логин"/>
        <form:label path="password" cssClass="sr-only">Пароль</form:label>
        <form:password path="password" cssClass="form-control input-lg" placeholder="Пароль"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form:form>

</div>
<!-- /container -->

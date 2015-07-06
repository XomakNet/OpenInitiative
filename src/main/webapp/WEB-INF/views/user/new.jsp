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
<style>
    .error-row{padding-left: 15px; padding-right: 15px; margin-top: 15px;}
</style>
<div class="container">
    <h1>
        Регистрация
    </h1>
    <form:form modelAttribute="newUserForm" action="" id="userForm" method="post" cssClass="form-horizontal">
        <div class="row">
            <div class="col-lg-2 col-md-2">
                <form:label path="login" cssClass="control-label">
                    Логин
                </form:label>
            </div>
            <div class="col-lg-10 col-md-10">
                <form:input path="login" cssClass="form-control no-bottom-radius" placeholder="Имя пользователя (латинские бувы, цифры и символы _-)"/>
            </div>
        </div>
        <div class="row error-row">
            <form:errors path="login" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2">
                <form:label path="email" cssClass="control-label">
                    E-mail
                </form:label>
            </div>
            <div class="col-lg-10 col-md-10">
                <form:input path="email" cssClass="form-control no-bottom-radius no-top-radius" placeholder="Адрес электронной почты"/>
            </div>
        </div>
        <div class="row error-row">
            <form:errors path="email" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2">
                <form:label path="password" cssClass="control-label">
                    Пароль
                </form:label>
            </div>
            <div class="col-lg-10 col-md-10">
                <form:password path="password" cssClass="form-control no-bottom-radius no-top-radius" placeholder="Пароль от 8 до 50 символов. Допускаются латинские бувы, цифры, символы !_-@"/>
            </div>
        </div>
        <div class="row error-row">
            <form:errors path="password" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2">
                <form:label path="passwordConfirmation" cssClass="control-label">
                    Пароль ещё раз
                </form:label>
            </div>
            <div class="col-lg-10 col-md-10">
                <form:password path="passwordConfirmation" cssClass="form-control no-top-radius" placeholder="Придуманный пароль ещё раз"/>
            </div>
        </div>
        <div class="row error-row">
            <form:errors path="passwordConfirmation" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="row text-center top-margin15 side-padding">
            <input type="submit" class="btn btn-success btn-lg btn-block" value="Продолжить"/>
        </div>
    </form:form>
</div>

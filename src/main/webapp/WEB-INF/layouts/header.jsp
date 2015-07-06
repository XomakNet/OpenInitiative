<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">OpenInitiative</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Создать петицию</a></li>
                <li><a href="#about">Инцииативы</a></li>
            </ul>
            <c:if test="${user == null}">
                <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/user/auth"
                      method="POST">
                    <div class="form-group">
                        <input type="text" name="login" placeholder="Логин" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" placeholder="Пароль" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">Войти</button>
                </form>
            </c:if>
            <c:if test="${user != null}">
                <div class="navbar-right">
                    <p class="navbar-text">
                            ${user.login}
                    </p>
                    <a href="${pageContext.request.contextPath}/user/logout" class="btn btn-success navbar-btn">Выйти</a>
                </div>
            </c:if>
        </div>
    </div>
</div>
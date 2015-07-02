<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 02.07.2015
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Сложное удаление</h1>

<div class="row">
    Категория не пуста. Выберите требуемое действие:
</div>
<div class="row">
    <c:url value="/category/${category.id}/delete/with-initiatives" var="deleteURL"/>
    <a href="${deleteURL}" class="btn btn-danger">Удалить также инициативы</a>
    <c:url value="/category/${category.id}/delete/disable" var="disableURL"/>
    <a href="${disableURL}" class="btn btn-success">Сделать категорию неактивной</a>
    <c:url value="/category/${category.id}/delete/change-category" var="changeURL"/>
    <a href="${changeURL}" class="btn btn-success">Поменять категорию на основную</a>
</div>
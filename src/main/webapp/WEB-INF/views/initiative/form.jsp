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
    .fulltext-row{padding-left: 15px; padding-right: 15px; }
</style>
<div class="container">
    <h1>
        Новая инициатива
    </h1>
    ${initiative}
    <form:form modelAttribute="initiative" action="" id="initiativeForm" method="post" cssClass="form-horizontal">
        <div class="row">
            <div class="col-lg-2 col-md-2">
                <form:label path="name" cssClass="control-label">
                    Название
                </form:label>
            </div>
            <div class="col-lg-10 col-md-10">
                <form:input path="name" cssClass="form-control" placeholder="Название инициативы"/>
            </div>
        </div>
        <div class="row error-row">
            <form:errors path="name" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2">
                <form:label path="description" cssClass="control-label">
                    Краткое описание
                </form:label>
            </div>
            <div class="col-lg-10 col-md-10">
                <form:textarea path="description" cssClass="form-control" placeholder="Краткое описание инициативы для отображения в поиске"/>
            </div>
        </div>
        <div class="row error-row">
            <form:errors path="description" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="row">
            <div class="col-lg-2 col-md-2">
                <form:label path="categories" cssClass="control-label">
                    Категории
                </form:label>
            </div>
            <div class="col-lg-10 col-md-10">
                <form:select path="categories" items="${categories}" itemValue="id" itemLabel="name" cssClass="form-control" id="categorySelect"/>
            </div>
        </div>
        <div class="row error-row">
            <form:errors path="categories" cssClass="alert alert-danger" element="div"/>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-4">
                <form:label path="text" cssClass="control-label">
                    Полный текст инициативы
                </form:label>
            </div>
            <div class="col-lg-8 col-md-8">
                <form:errors path="text" cssClass="alert alert-danger" element="div"/>
            </div>
        </div>
        <div class="row fulltext-row">
            <form:textarea path="text" cssClass="form-control" id="initiativeText"/>
        </div>

        <div class="row text-center top-margin15 side-padding">
            <input type="submit" class="btn btn-success btn-lg fullwidth" value="Создать"/>
        </div>
    </form:form>
</div>
<%--TODO: Do it it right way--%>
<script type="complexText/javascript">
    $(document).ready(function() {
        $('#categorySelect').multiselect();
    });

</script>
<script type="complexText/javascript" src="${pageContext.request.contextPath}/resources/js/tinymce/tinymce.min.js"></script>
<script type="complexText/javascript">
    tinymce.init({
        selector: "#initiativeText"
    });
</script>

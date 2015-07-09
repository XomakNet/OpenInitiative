<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: regis
  Date: 08.07.2015
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #statusesBox {
        margin-top: 15px;
    }

    #initiativeStatus {
        margin-left: 20px;
    }

    #statusesBox ul {
        display: inline-block;
    }

    #statusesBox ul * {
        display: inline-block;
        list-style: none;
    }
</style>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-9 col-md-9">

                <c:url var="searchURL" value="/initiatives/search"/>
                <form action="${searchURL}" method="POST">
                    <div class="input-group">
                    <input type="text" class="form-control" name="keyword" placeholder="фраза для поиска"/>
                  <span class="input-group-btn">
                    <input class="btn btn-default" type="submit">Поиск</input>
                  </span>
                    </div>
                </form>

            <div class="panel panel-default" id="statusesBox">
                <div class="panel-body">
                    По статусу:
                    <ul>
                        <c:forEach items="${statuses}" var="status">
                            <c:url value="/initiatives/status/${status.id}" var="byStatusURL"/>
                            <li>
                                <a class="label label-default" href="${byStatusURL}">${status.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div>


                <c:choose>
                    <c:when test="${isEmpty}">
                        <div class="alert alert-warning" role="alert">Не найдено инициатив по заданным параметрам</div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${initiatives.content}" var="initiative">
                            <div class="well">
                                <c:url var="initiativeURL" value="/initiatives/${initiative.id}"/>
                                <h3><a href="${initiativeURL}">${initiative.name}</a></h3>

                                <p>${initiative.description}</p>

                                <div>
                                    <c:choose>
                                        <c:when test="${initiative.votesFor-initiative.votesAgainst} < 0">
                                            <c:set var="votesClass" value="label-danger"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="votesClass" value="label-success"/>
                                        </c:otherwise>
                                    </c:choose>

                                    <span class="label ${votesClass}">
                                        Рейтинг: <b>${initiative.votesFor-initiative.votesAgainst}</b>
                                    </span>
                                    <c:choose>
                                        <c:when test="${initiative.status.isVotingActive == true}">
                                            <c:set var="statusClass" value="label-success"/>
                                        </c:when>
                                        <c:when test="${initiative.status.isFinal == true}">
                                            <c:set var="statusClass" value="label-default"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="votesClass" value="label-info"/>
                                        </c:otherwise>
                                    </c:choose>
                                    <span class="label ${statusClass}" id="initiativeStatus">
                                            ${initiative.status.name}
                                    </span>
                                </div>
                            </div>
                        </c:forEach>
                        <c:url var="firstUrl" value="/initiatives/${filterUrlPrefix}pages/1"/>
                        <c:url var="lastUrl" value="/initiatives/${filterUrlPrefix}pages/${totalPages}"/>
                        <c:url var="prevUrl" value="/initiatives/${filterUrlPrefix}pages/${currentIndex - 1}"/>
                        <c:url var="nextUrl" value="/initiatives/${filterUrlPrefix}pages/${currentIndex + 1}"/>
                        <nav>
                            <ul class="pagination">
                                <c:choose>
                                    <c:when test="${currentIndex == 1}">
                                        <li class="disabled"><a href="#">&lt;&lt;</a></li>
                                        <li class="disabled"><a href="#">&lt;</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${firstUrl}">&lt;&lt;</a></li>
                                        <li><a href="${prevUrl}">&lt;</a></li>
                                    </c:otherwise>
                                </c:choose>
                                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                                    <c:url var="pageUrl" value="/initiatives/${filterUrlPrefix}pages/${i}"/>
                                    <c:choose>
                                        <c:when test="${i == currentIndex}">
                                            <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:choose>
                                    <c:when test="${currentIndex == totalPages}">
                                        <li class="disabled"><a href="#">&gt;</a></li>
                                        <li class="disabled"><a href="#">&gt;&gt;</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${nextUrl}">&gt;</a></li>
                                        <li><a href="${lastUrl}">&gt;&gt;</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </ul>
                        </nav>
                    </c:otherwise>
                </c:choose>
            </div>


        </div>

        <div class="col-lg-3 col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Категории
                </div>
                <ul class="list-group">
                    <c:forEach items="${categories}" var="category">
                        <li class="list-group-item"><a
                                href="${pageContext.request.contextPath}/initiatives/category/${category.id}">${category.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    По популярности
                </div>
                <ul class="list-group">
                    <c:url value="/initiatives/toprated" var="topRankedURL"/>
                    <li class="list-group-item"><a href="${topRankedURL}">Наиболее поддерживаемые</a></li>
                    <%--<c:url value="/initiatives/top-commented" var="topCommentedURL"/>--%>
                    <%--<li class="list-group-item"><a href="${topCommentedURL}">Наиболее обсуждаемые</a></li>--%>
                </ul>
            </div>
        </div>
    </div>
</div>
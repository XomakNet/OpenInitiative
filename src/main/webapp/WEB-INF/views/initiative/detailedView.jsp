<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: regis
  Date: 07.07.2015
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #votesTotal > *:first-child {
        font-size: 20px;
        display: block;
    }

    #votesDetails > * {
        display: inline-block;
        width: 50%;
        /*margin: 0px;*/
        /*box-sizing: border-box;*/
    }
    #votesDetails .btn {
        display: block;
    }
</style>
<div class="container">
    <div class="row">
        <div class="col-lg-9 col-md-9">
            <h1>${initiative.name}</h1>
            ${initiative.complexText.text}
        </div>
        <div class="col-lg-3 col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Голосование
                </div>
                <div class="panel-body">
                    <div id="votesTotal" class="row text-center">
                        <b>${initiative.votesFor - initiative.votesAgainst}</b>
                        итого
                    </div>
                    <div>
                        <div class="progress">
                            <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                 aria-valuemax="100" style="width: ${votesPercent}%;">
                                ${votesPercent} %
                            </div>
                        </div>
                    </div>
                    <div id="votesDetails">
                        <c:url var="voteForURL" value="/initiatives/${initiative.id}/vote/for"/>
                        <c:url var="voteAgainstURL" value="/initiatives/${initiative.id}/vote/against"/>
                        <c:choose>
                            <c:when test="${userVote == null}">

                            </c:when>
                            <c:when test="${userVote.votedFor}">
                                <c:set var="voteForClass" value="disabled"/>
                                <c:set var="voteAgainstClass" value="disabled"/>
                                <c:set var="votedText" value="Вы проголосовали за"/>
                            </c:when>
                            <c:when test="${!userVote.votedFor}">
                                <c:set var="voteForClass" value="disabled"/>
                                <c:set var="voteAgainstClass" value="disabled"/>
                                <c:set var="votedText" value="Вы проголосовали против"/>
                            </c:when>
                        </c:choose>


                        <div class="text-left">
                            <b>${initiative.votesFor}</b> за
                            <a class="btn btn-success ${voteForClass}" href="${voteForURL}">Я за!</a>
                        </div><!--
                     --><div class="text-right">
                            <b>${initiative.votesAgainst}</b> против
                            <a class="btn btn-danger ${voteAgainstClass}" href="${voteAgainstURL}">Я против!</a>
                        </div>
                    </div>
                    <div>${votedText}</div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    История
                </div>
                <div class="panel-body">
                    <table class="table">
                        <tr>
                            <th>Дата и время</th>
                            <th>Статус</th>
                        </tr>
                        <c:forEach items="${statusHistory}" var="statusHistoryItem">
                            <tr>
                                <td><fmt:formatDate type="both"
                                                    dateStyle="short" timeStyle="short"
                                                    value="${statusHistoryItem.dateTime}" /></td>
                                <td data-toggle="tooltip" data-placement="left" title="${statusHistoryItem.newStatus.description}">${statusHistoryItem.newStatus.name}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>

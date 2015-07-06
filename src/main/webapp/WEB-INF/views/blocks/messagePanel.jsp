<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: regis
  Date: 06.07.2015
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${message != null}">
  <%--<c:choose>--%>
    <%--<c:when test="${message.type == message.Type.}">--%>

    <%--</c:when>--%>
  <%--</c:choose>--%>
  <c:set var="panelClass" value="panel-danger"/>
  <div class="panel ${panelClass}">
    <div class="panel-heading">
      <h3 class="panel-title">${message.title}</h3>
    </div>
    <div class="panel-body">
        ${message.message}
    </div>
  </div>
</c:if>

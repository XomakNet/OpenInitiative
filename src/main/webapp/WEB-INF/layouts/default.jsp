<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!doctype html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" />
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <script src="http://code.jquery.com/jquery-latest.js"><!-- --></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"><!-- --></script>
    </head>
    <body>


        <div class="container">

          <div class="starter-template">
            <h1>Bootstrap starter template</h1>
            <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
          </div>

        </div><!-- /.container -->
        <tiles:insertAttribute name="body" />
    </body>
</html>
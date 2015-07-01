<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!doctype html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" />
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <script src="http://code.jquery.com/jquery-latest.js"><!-- --></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"><!-- --></script>
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
    </head>
    <body>

        <tiles:insertAttribute name="header" />
        <div class="container-fluid">

              <tiles:insertAttribute name="body" />

        </div><!-- /.container -->

    </body>
</html>
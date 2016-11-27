<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>


<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<title>Mailing List</title>--%>
    <%--<link rel="stylesheet" type="text/css" href="../webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="../resources/css/community.css">--%>
<%--</head>--%>

<%--<body>--%>

<div class="wrapper">
    <div class="container">
        <div id="landing-page">
            <section id="first" class="row">
                <div>
                    <h1 class="first_title">${first_title}</h1>
                    <p class="first_body">
                        ${first_body}
                    </p>
                </div>
            </section>
        </div><!--/#landing-page-->
    </div><!--/.container-->
</div><!--/.wrapper-->

<footer id="footer">
    <div class="container">
        <div class="center">
            (c) CommunityTable 2016
        </div>
    </div>
</footer>

<script type="text/javascript" src="../webjars/jquery/3.1.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="../webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>

</html>

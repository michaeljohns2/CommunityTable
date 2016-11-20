<%--
  This is the Admin Login page.
  For an example of how Spring 4 Security custom login pages, see:
  http://websystique.com/spring-security/spring-security-4-custom-login-form-annotation-example/
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Administrative Login</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/css/community.css">
</head>
<body>
    <div class="wrapper">

        <div class="container">
            <section id="login-form" class="row login-form">
                <div class="col-sm-3"></div>
                <div class="col-sm-6 center">
                    <c:url var="loginUrl" value="/login.html" />
                    <form action="${loginUrl}" method="post" class="">
                        <c:if test="${param.error != null}">
                            <div class="alert-error">
                                <p>${login_error}</p>
                            </div>
                        </c:if>

                        <c:if test="${param.logout != null}">
                            <div class="alert-success">
                                <p>${logout_success}</p>
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="username">${username_label}</label>
                            <input type="text" class="form-control" id="username" name="username"
                                   placeholder="${username_input_text}" required>
                        </div>
                        <div class="form-group">
                            <label for="password">${password_label}</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="${password_input_text}" required>
                        </div>

                        <%-- This hidden field helps to prevent CSRF attacks --%>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                        <div>
                            <input class="btn btn-lg btn-warning" type="submit" value="${login_button}">
                        </div>
                    </form>
                </div>
                <div class="col-sm-3"></div>
            </section>
        </div><!--/.container-->
    </div><!--/.wrapper-->

</body>
</html>

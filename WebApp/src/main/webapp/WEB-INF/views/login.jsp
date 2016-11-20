<%--
  This is the Admin Login page.
  For an example of how Spring 4 Security custom login pages, see:
  http://websystique.com/spring-security/spring-security-4-custom-login-form-annotation-example/
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Administrative Login</title>
</head>
<body>

<div class="login-form">
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

        <div class="">
            <label class="" for="username">${username_label}</label>
            <input type="text" class="" id="username" name="username" placeholder="${username_input_text}" required>
        </div>
        <div class="">
            <label class="" for="password">${password_label}</label>
            <input type="password" class="" id="password" name="password" placeholder="${password_input_text}" required>
        </div>

        <%-- This hidden field helps to prevent CSRF attacks --%>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <div>
            <input type="submit" value="${login_button}">
        </div>
    </form>

</body>
</html>

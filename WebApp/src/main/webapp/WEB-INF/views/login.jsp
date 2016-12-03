<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container" id="login-form" >
    <section class="row login-form">
        <div class="col-sm-3"></div>
        <div class="col-sm-6 center">
            <c:url var="loginUrl" value="/login.html" />
            <form action="${loginUrl}" method="post" class="">
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger alert-dismissable">
                        <p>${login_error}</p>
                    </div>
                </c:if>

                <c:if test="${param.logout != null}">
                    <div class="alert alert-success alert-dismissable">
                        <p>${logout_success}</p>
                    </div>
                </c:if>

                <div class="form-group">
                    <label for="username">${username_label}</label>
                    <input type="text" class="form-control input-lg" id="username" name="username"
                           placeholder="${username_input_text}" required>
                </div>
                <div class="form-group">
                    <label for="password">${password_label}</label>
                    <input type="password" class="form-control input-lg" id="password" name="password"
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

<c:import url="shared/_footer.jsp"/>
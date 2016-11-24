<%--
  This is the administrative dashboard view.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../shared/_header.jsp"/>

<div class="container" id="admin-dashboard" >
    <section class="row">
        <div class="col-sm-3">
            <c:import url="../shared/_admin_nav.jsp"/>
        </div>
        <div class="col-sm-6">
            ${admin_main}
        </div>
        <div class="col-sm-3">
            ${admin_main_actions}
        </div>
    </section>
</div><!--/.container-->

<c:import url="../shared/_footer.jsp"/>
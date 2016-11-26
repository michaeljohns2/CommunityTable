<%--
  This is the administrative dashboard view.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../shared/_header.jsp"/>
<c:import url="../shared/_nav.jsp"/>

<div class="container" id="admin-dashboard" >
    <section class="row">

        <div class="col-sm-3" id="admin_left">
            <ul class="nav nav-pills nav-stacked">
                <li><a id="js-get-emails" href="#">Display All Emails</a></li>
            </ul>
            <%--
            <c:import url="../shared/_admin_nav.jsp"/>
            --%>
        </div>

        <div class="col-sm-6" id="admin_middle">
            ${admin_main}
            This is where emails will be displayed.

        </div>

        <div class="col-sm-3" id="admin_right">
            ${admin_main_actions}
        </div>
    </section>
</div><!--/.container-->

<c:import url="../shared/_footer.jsp"/>
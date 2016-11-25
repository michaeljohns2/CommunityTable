<%--
  This is the administrative dashboard view.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../shared/_header.jsp"/>

<div class="container" id="admin-dashboard" >
    <section class="row">

        <div class="col-sm-3" style="float:left; width:33%;border-style:solid;border-width:1px">
            <a id="js-get-emails" href="">Display All Emails</a>
            <%--
            <c:import url="../shared/_admin_nav.jsp"/>
            --%>
        </div>

        <div class="col-sm-6" style="display:inline-block;width: 33%;border-style:solid;border-width:1px">
            ${admin_main}
            This is where emails will be displayed.

        </div>

        <div class="col-sm-3" style="float:right; width:31%;border-style:solid;border-width:1px">
            ${admin_main_actions}
        </div>
    </section>
</div><!--/.container-->

<c:import url="../shared/_footer.jsp"/>
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

        <div class="col-sm-2" id="admin_left">
            <ul class="nav nav-pills nav-stacked">
                <li><a id="js-get-emails" href="#">Display All Emails</a></li>
                <li><a id="new-blog" href="#">Create new blog</a></li>
            </ul>
            <%--
            <c:import url="../shared/_admin_nav.jsp"/>
            --%>
        </div>

        <div class="col-sm-8 wrap" id="admin_middle">

            <c:if test="${not empty admin_confirmation}">
                <div class="admin-confirmation">
                ${admin_confirmation}
                </div>
            </c:if>

            <div>
                ${admin_main}
            </div>

            <c:if test="${not empty blogList}">
                <table border="0">
                    <tr>
                        <th>Subject</th>
                        <th>Created On</th>
                        <th>Actions</th>
                    </tr>

                    <tbody>
                    <c:forEach var="blogEntry" items="${blogList}">
                        <tr>
                            <td>${blogEntry.getSubject()}</td>
                            <td>${blogEntry.getCreatedDateForDisplay()}</td>
                            <td><a href="/CommunityTables/admin/deleteBlog.html?id=${blogEntry.getBlogId()}">delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

        </div>

        <div class="col-sm-2" id="admin_right">
            ${admin_main_actions}
        </div>
    </section>
</div><!--/.container-->

<c:import url="../shared/_admin_footer.jsp"/>

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
                <!-- TODO: write the js so that this loads the Admin index which displays all blogs
                <li><a id="admin-index" href="#"><span class="glyphicon glyphicon-home"></span> List all Blogs</a></li>
                -->
                <li><a id="new-blog" href="#"><span class="glyphicon glyphicon-pencil"></span> Create new blog</a></li>
                <li><a id="js-get-emails" href="#"><span class="glyphicon glyphicon-list-alt"></span> Display All
                    Emails</a></li>
            </ul>
            <%--
            <c:import url="../shared/_admin_nav.jsp"/>
            --%>
        </div>

        <div class="col-sm-8 wrap" id="admin_middle">

            <c:if test="${not empty admin_confirmation}">
                <div class="admin-confirmation alert alert-info alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    ${admin_confirmation}
                </div>
            </c:if>

            <h1>
                ${admin_main}
            </h1>

            <c:if test="${not empty blogList}">
                <table class="table table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Created On</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="blogEntry" items="${blogList}">
                        <tr>
                            <td class="large-text"><a href="/CommunityTables/blog/${blogEntry.getBlogId()}.html
">${blogEntry.getSubject()}</a></td>
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

<%--
  User: keljd
  Date: 12/6/2016
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container" id="blog-list">
    <section class="row">
        <h1 class="title_1">${title_1}</h1>
        <c:if test="${not empty blogList}">
            <c:forEach var="blogEntry" items="${blogList}">
            <a class="title-link" href="/CommunityTables/blog/${blogEntry.getBlogId()}.html">
                <h2>${blogEntry.getSubject()}</h2>
            </a>
                <p class="small">Published on: ${blogEntry.getCreatedDateForDisplay()}</p>

                <a class="btn btn-warning" href="/CommunityTables/blog/${blogEntry.getBlogId()}.html">Read full
                    entry</a>
            </c:forEach>
        </c:if>
    </section>
</div>

<c:import url="shared/_footer.jsp"/>
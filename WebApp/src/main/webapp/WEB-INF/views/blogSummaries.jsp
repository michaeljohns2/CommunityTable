<%--
  User: keljd
  Date: 12/6/2016
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container">
    <c:if test="${not empty blogList}">
        <c:forEach var="blogEntry" items="${blogList}">
            <div>
                ${blogEntry.getSubject()} (${blogEntry.getCreatedDateForDisplay()})
            </div>

            <div>
                <a href="/CommunityTables/blog/${blogEntry.getBlogId()}.html">(Read full entry)</a>
            </div>
        </c:forEach>
    </c:if>
</div>

<c:import url="shared/_footer.jsp"/>
<%--
  User: keljd
  Date: 12/6/2016
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_blog_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container" id="blog-detail">
    <section class="row">
        <c:if test="${not empty blogEntry}">
            <h1>${blogEntry.getSubject()}</h1>
            <p class="small">Published on: ${blogEntry.getCreatedDateForDisplay()}</p>

            <div class="body">
                ${blogEntry.getBody()}
            </div>
        </c:if>
    </section>
</div>

<c:import url="shared/_footer.jsp"/>
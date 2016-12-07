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
    <c:if test="${not empty blogEntry}">
        <div>
            ${blogEntry.getSubject()} (${blogEntry.getCreatedDateForDisplay()})
        </div>

        <div>
            ${blogEntry.getBody()}
        </div>
    </c:if>
</div>

<c:import url="shared/_footer.jsp"/>
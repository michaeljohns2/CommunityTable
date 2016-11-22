<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container" id="about-page">
    <section class="row">
        <div>
            <h1 class="title_1">${title_1}</h1>
            <p class="body_1">
                ${body_1}
            </p>
        </div>
    </section>

    <section class="row">
        <div>
            <h1 class="title_2">${title_2}</h1>
            <p class="body_2">
                ${body_2}
            </p>
        </div>
    </section>
    <section class="row">
        <div>
            <h1 class="title_3">${title_3}</h1>
            <p class="body_3">
                ${body_3}
            </p>
        </div>
    </section>
    <section class="row">
        <div>
            <h1 class="title_4">${title_4}</h1>
            <p class="body_4">
                ${body_4}
            </p>
        </div>
    </section>
</div><!--/.container-->

<c:import url="shared/_footer.jsp"/>
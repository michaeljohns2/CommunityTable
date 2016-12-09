<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container" id="landing-page">
    <section class="row">
        <div class="col-sm-12">
            <h1 class="title_1">${title_1}</h1>
            <p class="body_1">
                ${body_1}
            </p>
        </div>
    </section>

    <section class="row">
        <div class="col-sm-12">
            <h2 class="title_2">${title_2}</h2>
            <p class="body_2">
                ${body_2}
            </p>
        </div>
    </section>

    <section class="row">
        <div class="col-sm-12">
            <h2 class="title_3">${title_3}</h2>
            <p class="body_3">
                ${body_3}
            </p>
            <div id="emailSubmit" class="center">
                <form id="subscribeToNewsletter" onsubmit="sendEmailRequest();">
                    <input type="email" id="emailAddress" placeholder="your@email.com">
                    <button class="btn btn-lg btn-warning" type="submit">${submit_label}</button>
                </form>
                <p class="small">* We hate spam too. Don't worry, we won't share your email.</p>
            </div>
            <div id="failSubscription" class="subscriptionStatus alert alert-warning">
                <p>
                    ${fail_message}
                </p>
            </div>
            <div id="successfulSubscription" class="subscriptionStatus alert alert-success" role="alert">
                <p>
                    ${success_message}
                </p>
            </div>
        </div>
    </section>
</div><!--/.container-->

<c:import url="shared/_footer.jsp"/>
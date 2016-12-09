<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="shared/_header.jsp"/>
<c:import url="shared/_nav.jsp"/>

<div class="container" id="landing-page">
    <section id="first" class="row">
        <div class="col-sm-12">
            <h1 class="first_title">${first_title}</h1>
            <p class="first_body">
                ${first_body}
            </p>
        </div>
    </section>

    <section id="second" class="row">
        <div class="col-sm-12">
            <h1 class="second_title">${second_title}</h1>
            <p class="second_body">
                ${second_body}
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
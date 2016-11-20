<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="shared/header.jsp"/>
<body>
	<c:import url="shared/navigation.jsp"/>

	<div class="wrapper">

		<div class="container">
			<div id="landing-page">
				<section id="first" class="row">
					<div>
						<h1 class="first_title">${first_title}</h1>
						<p class="first_body">
							${first_body}
						</p>
					</div>
				</section>

				<section id="second" class="row">
					<div>
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

			</div><!--/#landing-page-->
		</div><!--/.container-->
	</div><!--/.wrapper-->

	<script type="text/javascript" src="webjars/jquery/3.1.1/dist/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/ping.js"></script>
	<script type="text/javascript" src="resources/js/community.js"></script>

	<c:import url="shared/footer.jsp"/>
</body>
 
 
</html>

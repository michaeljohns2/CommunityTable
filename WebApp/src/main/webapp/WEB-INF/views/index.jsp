<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Community Tables</title>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/community.css">
</head>
 
<body>
	<div id="wrap">
		<div class="container">
			<section id="landing-page">
				<div class="row" id="main-content">
					<h1 class="center huge-text">${greeting}</h1>

				    <p class="large-text">
				    	${body}
				    </p>

				</div><!--/.row-->
			</section><!--/.main-content-->
		</div><!--/.container-->
	</div><!--/#wrap-->

	<footer id="footer">
		<div class="container">
			<div id="emailSubmit">
				<form id="subscribeToNewsletter" onsubmit="sendEmailRequest();">
					<input type="text" id="emailAddress">
					<input type="submit" value="Enter Email" />
				</form>
			</div>
			<div id="subscribe">
				<a href="javascript:void(0)" onclick="enterEmail();">Subscribe via Email</a>
			</div>
			<div id="failSubscription" class="subscriptionStatus">
				<p>
					Fail
				</p>
			</div>
			<div id="successfulSubscription" class="subscriptionStatus">
				<p>
					Success
				</p>
			</div>
			<div>
				(c) CommunityTable 2016
			</div>
		</div>
	</footer>

    <script type="text/javascript" src="webjars/jquery/3.1.1/dist/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<%--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>--%>
	<script type="text/javascript" src="resources/js/community.js"></script>
</body>
 
 
</html>
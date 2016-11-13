<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Community Tables</title>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/community.css">
</head>
 
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/CommunityTables">${brand}</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse pull-right">
				<ul class="nav navbar-nav">
					<li><a href="#first">${first_nav_title}</a></li>
					<li><a href="#second">${second_nav_title}</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</nav>
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

	<footer id="footer">
		<div class="container">
			<div class="center">
				(c) CommunityTable 2016
			</div>
		</div>
	</footer>

    <script type="text/javascript" src="webjars/jquery/3.1.1/dist/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/ping.js"></script>
	<script type="text/javascript" src="resources/js/community.js"></script>
</body>
 
 
</html>

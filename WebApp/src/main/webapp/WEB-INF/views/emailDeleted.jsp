<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mailing list sign-up</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/CommunityTables/css/community.css">
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
                <a class="navbar-brand" href="/">${brand}</a>
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
             <div id="email-deleted">
                 <section id="first" class="row">
                     <div>
                         <h1 class="first_title">${first_title}</h1>
                         <p class="first_body">${first_body}</p>
                     </div>
                 </section>

                 <section id="second" class="row">
                     <div>
                         <h1 class="second_title">${second_title}</h1>
                         <p class="second_body">${second_body}</p>
                     </div>
                 </section>

             </div><!--/#email-deleted-->
         </div><!--/.container-->
     </div><!--/.wrapper-->

     <footer id="footer">
         <div class="container">
             <div class="row center">
                 (c) CommunityTable 2016
             </div>
         </div>
     </footer>

</body>
</html>
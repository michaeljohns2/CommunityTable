<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <%-- These tags are used to enable AJAX calls to bypass Spring anti-CSRF --%>
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>

        <title>${title}</title>
        <link rel="stylesheet" type="text/css" href="/CommunityTables/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/CommunityTables/resources/css/community.css">
    </head>
    <body>
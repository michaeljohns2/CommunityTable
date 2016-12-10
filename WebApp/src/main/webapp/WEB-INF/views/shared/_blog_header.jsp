<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%--These tags are needed for open graph rendering of blog (e.g. Facebook or Twitter)--%>
    <meta property="og:type" content="blog" />
    <meta property="og:title" content="${blogEntry.getSubject()}" />
    <meta property="og:description" content="${blogEntry.getBodyPreview()}" />
    <meta property="og:image" content="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/${blogEntry.getFeaturedImgRelativeUrl()}" />
    <meta property="og:image:type" content="${featured_img_mime_type}" />

    <%-- These tags are used to enable AJAX calls to bypass Spring anti-CSRF --%>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/CommunityTables/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/CommunityTables/resources/css/community.css">
</head>
<body>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Blog Entry</title>
</head>
<body>
<div align="center">
    <form:form action="/CommunityTables/admin/blog.html" method="post" commandName="blogForm">
        <h2>Blog Entry</h2>

        <div>
            Subject: <form:input path="subject" />
        </div>

        <div>
            Body: <form:input path="body" />
        </div>

        <div>
            <input type="submit" value="Save Blog Entry" />
        </div>
    </form:form>
</div>
</body>
</html>
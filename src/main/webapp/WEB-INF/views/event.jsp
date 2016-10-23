<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Event Page</title>
    <link rel="stylesheet" type="text/css" href="/css/community.css">
</head>
<body>


<form:form commandName="event">
    <form:errors path="*" cssClass="errorBlock" element="div" />
    <label for="name">Enter Event Name:</label>
    <form:input path="name"  cssErrorClass="error" />
    <form:errors path="name" cssClass="error"  />
    <br>
    <input type="submit" value="Enter Event" />
</form:form>


</body>
</html>
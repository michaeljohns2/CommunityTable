<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Mailing list sign-up</title>
    <link rel="stylesheet" type="text/css" href="/CommunityTables/css/community.css">
</head>
<body>


<form:form modelAttribute="emailAddressModel">
    <form:errors path="*" cssClass="errorBlock" element="div" />
    <label for="emailAddress">${reglbl}</label>
    <form:input path="emailAddress"  cssErrorClass="error" />
    <form:errors path="emailAddress" cssClass="error"  />
    <br>
    <input type="submit" value="Enter Email" />
</form:form>


</body>
</html>
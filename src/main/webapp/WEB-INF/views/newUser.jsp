<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new user</title>
        <link rel="stylesheet" type="text/css" 
              href="${pageContext.request.contextPath}/resources/mystyles.css">
    </head>
    <body>
        <h1>Fill the form to register new user:</h1>
        <form:form method="post" modelAttribute="user" autocomplete="off">
            <form:label path="username">Username:</form:label><br />
            <form:input path="username" autofocus="true" /><br />
            <form:errors path="username" cssclass="error"></form:errors><br />
            
            <form:label path="password">Password:</form:label><br />
            <form:password path="password" /><br />
            <form:errors path="password" cssclass="error"></form:errors><br />
            
            <form:label path="userRoles">Select roles (press ctrl to select multiple options):</form:label><br />
            <form:select path="userRoles" items="${roles}" itemLabel="role"/>
            <form:errors path="userRoles" cssclass="error"></form:errors><br />
            
            <input type="submit" value="Submit">
            <a href="${pageContext.request.contextPath}/admin" class="cancel">Cancel</a>
        </form:form> 
    </body>
</html>

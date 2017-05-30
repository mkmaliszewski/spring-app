<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new contact</title>
        <link rel="stylesheet" type="text/css" href="resources/mystyles.css">
    </head>
    <body>
        <h1>Fill the form to add/edit a contact:</h1>
        <form:form action="/SpringApplication/save" method="post" 
                   modelAttribute="contact" autocomplete="off">
            <form:hidden path="id" />
            <form:label path="name">Name:</form:label><br />
            <form:input path="name"></form:input><br />
            <form:label path="lastName">Last Name:</form:label><br />
            <form:input path="lastName"></form:input><br />
            <form:label path="mail">Mail:</form:label><br />
            <form:input path="mail"></form:input><br />
            <form:label path="number">Number:</form:label><br />
            <form:input path="number"></form:input><br />
            <form:label path="bornDate">Born date:</form:label><br />
            <form:input path="bornDate"></form:input><br />
            <input type="reset">
            <input type="submit">
        </form:form>
    </body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new contact</title>
    </head>
    <body>
        <h1>Fill the form to add a new contact:</h1>
        <form:form action="/SpringApplication/save" method="post" modelAttribute="contact">
            <form:hidden path="id" />
            <form:label path="name">Name:</form:label>
            <form:input path="name"></form:input>
            <form:label path="lastName"> last Name:</form:label>
            <form:input path="lastName"></form:input>
            <form:label path="mail">mail:</form:label>
            <form:input path="mail"></form:input>
            <form:label path="number">number:</form:label>
            <form:input path="number"></form:input>
            <form:label path="bornDate">born date:</form:label>
            <form:input path="bornDate"></form:input>
            <input type="submit">
        </form:form>
    </body>
</html>

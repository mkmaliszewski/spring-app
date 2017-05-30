<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Contacts list</h1>
        <p>New contact:</p>
        <a href="add">New contact</a>
        <table>
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Last Name</td>
                    <td>Mail</td>
                    <td>Number</td>
                    <td>Born</td>
                    <td colspan="2">Ation</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${listOfContacts}" var="contact">
                <tr>
                    <td>${contact.name}</td>
                    <td>${contact.lastName}</td>
                    <td>${contact.mail}</td>
                    <td>${contact.number}</td>
                    <td>${contact.bornDate}</td>
                    <td><a href="edit/${contact.id}">Edit</a></td>
                    <td><a href="delete/${contact.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
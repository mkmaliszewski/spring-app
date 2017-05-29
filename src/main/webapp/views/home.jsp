<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>HOme Page</h1>
        <table>
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Last Name</td>
                    <td>Mail</td>
                    <td>Number</td>
                    <td>Born</td>
                    <td colspan = "2">Ation</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${listOfContacts}" var="contact">
                <tr>
                    <td><c:out value="${contact.name}" /></td>
                    <td><c:out value="${contact.lastName}" /></td>
                    <td><c:out value="${contact.mail}" /></td>
                    <td><c:out value="${contact.number}" /></td>
                    <td><c:out value="${contact.bornDate}" /></td>
                    <td><a href="Controller?action=edit&id=<c:out value="${contact.id}" />">Edit</a></td>
                    <td><a href="Controller?action=delete&id=<c:out value="${contact.id}" />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>

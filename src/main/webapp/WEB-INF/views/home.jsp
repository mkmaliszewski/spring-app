<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" 
              href="${pageContext.request.contextPath}/resources/mystyles.css">
    </head>
    <body>
        <div>
            <h2>Contacts list</h2>
            <p style="position:absolute; right:10px; top:5px">
                Logged as: ${pageContext.request.userPrincipal.name}
            </p>
            <a class="button" style="position:absolute;right:10px;top:55px" 
               href="javascript:submitLogoutForm()">Logout</a>
        </div>
        <form id="logoutForm" 
              action="${pageContext.request.contextPath}/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" 
                   value="${_csrf.token}" />
        </form>
        <sec:authorize access="hasRole('ROLE_USER')">
            <p>Click the button below to add new contact:</p>
            <a href="${pageContext.request.contextPath}/add" 
               class="button">New contact</a>
        </sec:authorize>
        <br /><br />
        <c:if test="${!empty listOfContacts}">
            <table>
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Last Name</td>
                        <td>Mail</td>
                        <td>Number</td>
                        <td>Born</td>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <td colspan="2">Ation</td>
                        </sec:authorize>
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
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <td>
                                <a class="button" style="background-color: cornflowerblue; color: white;"
                                   href="${pageContext.request.contextPath}/edit/${contact.id}">Edit</a>
                            </td>
                            <td>
                                <a class="button" style="background-color: red; color: white;"
                                   href="${pageContext.request.contextPath}/delete/${contact.id}">Delete</a>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <h2> Click here to go to the admin's panel: 
            <a class="button" href="${pageContext.request.contextPath}/admin">Admin</a></h2>
        </sec:authorize>
        <script>
            function submitLogoutForm(){
                document.getElementById("logoutForm").submit();
            }
        </script>
    </body>
</html>
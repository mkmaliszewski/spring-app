<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin's panel</title>
        <link rel="stylesheet" type="text/css" 
              href="${pageContext.request.contextPath}/resources/mystyles.css">
    </head>
    <body>
        <div>
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
        <h2>Click here to register new user:
            <a class="button" href="${pageContext.request.contextPath}/admin/registration">register</a>
        </h2>
        <h2>Click here to go to contacts list:
            <a class="button" href="${pageContext.request.contextPath}/list">contacts</a>
        </h2>
        
        <c:if test="${!empty listOfUsers}">
            <table>
                <thead>
                    <tr>
                        <td>Username</td>
                        <td>Password</td>
                        <td>Roles</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listOfUsers}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.userRoles}</td>
                        <td><a class="button" style="background-color: red; color: white;" 
                               href="${pageContext.request.contextPath}/admin/delete/${user.username}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <script>
            function submitLogoutForm(){
                document.getElementById("logoutForm").submit();
            }
        </script>
    </body>
</html>

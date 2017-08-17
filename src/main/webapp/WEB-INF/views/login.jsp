<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" 
              href="${pageContext.request.contextPath}/resources/loginstyles.css">
    </head>
    <body>
        <div class="wrapper">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
	</c:if>
        
        <h2 class="header">Login with your account</h2>
        <form id="loginForm"
              action="${pageContext.request.contextPath}/login" method='post'>
            <input type='text' id="user" 
                   name='username' autofocus placeholder="Username"/>
            <input type='password' id="pass" 
                   name='password' placeholder="Password"/>
            <input type="hidden" name="${_csrf.parameterName}" 
                   value="${_csrf.token}" />
            <input type="submit" value="Log in" />
            <strong>or</strong>
            <a href="javascript:loginAsGuest()">
                <button type="button">Login as guest</button>
            </a>
        </form>
        </div>
            
        <script>
            function loginAsGuest(){
                document.getElementById("user").value = "guest";
                document.getElementById("pass").value = "guest";
                document.getElementById("loginForm").submit();
            }
        </script>
    </body>
</html>

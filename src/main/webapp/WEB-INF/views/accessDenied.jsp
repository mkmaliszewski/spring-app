<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access denied</title>
        <link rel="stylesheet" type="text/css" 
              href="${pageContext.request.contextPath}/resources/deniedstyles.css">
    </head>
    <body>
        <div class="container">
            <h1>
                <span>X</span> 
                Access denied, you don't have permission to view this page.
            </h1>
            <p>Click <a href="javascript:history.back()">here</a> 
                to go back.</p>
        </div>
    </body>
</html>

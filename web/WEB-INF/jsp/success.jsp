<%-- 
    Document   : success
    Created on : 04.02.2016, 14:44:32
    Author     : Raiymbet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="success">
            Confirmation message : <c:out value="${success}"/>
            <br>
            We have also sent you a confirmation mail to your email address : <c:out value="${user.email}"/>.
        </div>
    </body>
</html>

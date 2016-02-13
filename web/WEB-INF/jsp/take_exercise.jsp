<%-- 
    Document   : take_exercise
    Created on : 24.01.2016, 17:16:14
    Author     : Raiymbet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Бағдарламалауды үйрену</title>        
        <link type="text/css" rel="shortcut icon" href="<c:url value="/resources/img/title_logo1.png" />">
        <link type="text/css" href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css" />" rel="stylesheet">
        
        <script src="<c:url value="/resources/lib/jquery-2.1.4.js" />"></script>
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script>
    </head>
    <body>
        <div class="row">
            
            <%-- Exercise description --%>
            <div class="col-md-4">
                <textarea id="exercise" readonly style="width: 100%; height: 300px;">
                    
                </textarea>
            </div>
            
            <%-- Exercise file input --%>
            <div class="col-md-4">
                <textarea id="code_input" style="width: 100%; height: 300px;">
                    
                </textarea>
            </div>
            
            <%-- Exercise result of compile and run --%>
            <div class="col-md-4" id="result" readonly style="width: 100%; height: 300px;">
                
            </div>
        </div>
    </body>
</html>

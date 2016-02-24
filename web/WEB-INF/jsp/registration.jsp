<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Бағдарламалауды үйрену</title>        
        <link type="text/css" rel="shortcut icon" href="<c:url value="/resources/img/title_logo1.png" />">
        <link type="text/css" href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="/resources/custom/css/registration_page.css"/>" rel="stylesheet">
        
        <script src="<c:url value="/resources/lib/jquery-2.1.4.js" />"></script>
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script>
    </head>
    <body>
        
        <div class="col-md-6 col-md-offset-3">
            <h1>Hello World from Registration Page!</h1>
            <form:form name="register_form" method="POST" commandName="user">
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </div>
                        <form:input path="id" class="form-control" placeholder="Id" />                        
                    </div>
                        <form:errors path="id" cssClass="errors"/>
                </div>
                        
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </div>
                        <form:input path="name" class="form-control" placeholder="Name" />                        
                    </div>
                        <form:errors path="name" cssClass="errors"/>
                </div>
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </div>
                        <form:input path="surname" class="form-control" placeholder="Surname"/>                        
                    </div>
                        <form:errors path="surname" cssClass="errors"/>
                </div>
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-envelope"></i>
                        </div>
                        <form:input path="email" class="form-control" placeholder="Email" />                        
                    </div>
                        <form:errors path="email" cssClass="errors"/>
                </div>
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-lock"></i>
                        </div>
                        <form:password path="password" class="form-control" placeholder="Password" />                        
                    </div>
                        <form:errors path="password" cssClass="errors"/>
                </div>
                
                <button class="btn btn-success" type="submit">Register</button>
            </form:form>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        
        <div class="col-md-6 col-md-offset-3">
            <h1>Hello World from Registration Page!</h1>
            <form name="register_form" method="POST" modelAttribute="users">
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </div>
                        <input type="text" path="name" class="form-control" placeholder="Name" />
                        <div class="has-error">
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                        </div>
                        <input type="text" path="surname" class="form-control" placeholder="Surname"/>
                        <div class="has-error">
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-envelope"></i>
                        </div>
                        <input type="email" path="email" class="form-control" placeholder="Email" />
                        <div class="has-error">
                            
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-lock"></i>
                        </div>
                        <input type="password" path="password" class="form-control" placeholder="Password" />
                        <div class="has-error">
                            
                        </div>
                    </div>
                </div>
                
                <button class="btn btn-success" type="submit">Register</button>
            </form>
        </div>
    </body>
</html>

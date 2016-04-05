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
        
        <div class="center-block" style="position: relative;
                width: 40%;
                padding: 15px;
                margin-top: 5%;
                background-color: #fff;
                -webkit-background-clip: padding-box;
                background-clip: padding-box;
                border: 1px solid #ccc; 
                background-color: #e9e9e9;
                ">
           
            <form:form name="register_form" method="POST" commandName="user">
                
                <div class="" style="min-height: 16.43px;
                    padding: 1px;
                    border-bottom: 1px solid #ccc;">
                    <h1 class="text-info">Жүйеге тіркелу</h1>
                </div>
                
                <div class="row">
                    <div class="col-md-12">                        
                        <p class="text-info">
                            Қош келдіңіз! Біз сіздің жүйе қолданушысы болатыныңызға қуаныштымыз.
                        </p>
                    </div>
                </div>
                
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
                
                <div class="row">
                    <div class="col-md-12">
                        <div style="float: left">                            
                            <a href="#" class="text-primary">Көмекке мұқтажсыз ба?</a>
                        </div>
                        <div style="float: right">
                            <a href="<%=request.getContextPath()%>/login.htm" class="text-primary">Кіру</a>                            
                        </div>
                    </div>
                </div>
                
                <div class="row" style="margin-top: 15px">
                    <div class="col-md-12">
                        <div style="float: right">                                     
                            <button class="btn btn-primary" type="submit">Тіркелу</button>
                            <a href="#" class="btn btn-primary">Болдырмау</a>                           
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>

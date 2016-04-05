<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page errorPage="error_pages/fail_login.jsp" %>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Бағдарламалауды үйрену</title>        
        <link type="text/css" rel="shortcut icon" href="<c:url value="/resources/img/title_logo1.png" />">
        <link type="text/css" href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="/resources/custom/css/login_page.css"/>" rel="stylesheet">
        
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
                border: 1px solid #999;
                border: 1px solid rgba(0,0,0,.2);
                border-radius: 6px;
                outline: 0;
                -webkit-box-shadow: 0 3px 9px rgba(0,0,0,.5);
                box-shadow: 0 3px 9px rgba(0,0,0,.5);    
                -webkit-box-shadow: 0 5px 15px rgba(0,0,0,.5);
                box-shadow: 0 5px 15px rgba(0,0,0,.5);
                ">
            
            <form:form name="login_form" method="POST" modelAttribute="login">
                <div class="" style="min-height: 16.43px;
                    padding: 1px;
                    border-bottom: 1px solid #e5e5e5;">
                    <h1 class="text-info">Login</h1>
                </div>
                
                <div class="row">
                    <div class="col-md-12">                        
                        <p class="text-info">
                            Қосымша мүмкіндіктерге қол жеткізу үшін жүйеге тіркеліп,
                            қолданушы ретінде кіріңіз.
                        </p>
                    </div>
                </div>
                
                <div class="form-group" style="margin-top: 15px">                               
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="glyphicon glyphicon-envelope"></i>
                        </div>
                        <form:input path="email" class="form-control" type="email" placeholder="Email" />
                    </div>
                        <form:errors path="email" cssClass="errors" />
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
                            <a href="#" class="text-primary">Көмек керек пе?</a>
                        </div>
                        <div style="float: right">
                            <a href="#" class="text-primary">Тіркелу</a>                            
                        </div>
                    </div>
                </div>
                
                <div class="row" style="margin-top: 15px">
                    <div class="col-md-12">
                        <div style="float: right">                                     
                            <button class="btn btn-primary" type="submit">Login</button>
                            <a href="#" class="btn btn-primary">Cancel</a>                           
                        </div>
                    </div>
                </div>
                
            </form:form>
        </div>
    </body>
</html>

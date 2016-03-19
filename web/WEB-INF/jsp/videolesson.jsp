<%-- 
    Document   : videolesson
    Created on : 12.02.2016, 13:43:26
    Author     : Raiymbet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Бағдарламалауды үйрену</title>        
        <link type="text/css" rel="shortcut icon" href="<c:url value="/resources/img/title_logo1.png" />">
        <link type="text/css" href="<c:url value="/resources/lib/bootstrap/css/bootstrap.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="/resources/custom/css/main_page.css" />" rel="stylesheet">
        
        <script src="<c:url value="/resources/lib/jquery-2.1.4.js" />"></script>
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script>
        
        <script src="<c:url value="/resources/custom/js/index.js"/>"></script>
    </head>
    <body>
        <div class="container-fluid">
            
            <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="collapse navbar-collapse">
                                          
                        <%-- Header --%>
                        <div class="row" style="margin: 0px">
                            <%@include file="./layout/header.jsp" %>
                        </div>  
                        <%-- Links --%>
                        <div class="row" style="margin: 0px"> 
                            <%@include file="./layout/navigation.jsp" %>                            
                        </div>   
                        
                </div>                
            </nav>                  
             
            <%-- Center --%>
            <div class="row" style=" padding: 0px; padding-top: 128px;">
                <div class="col-md-12" style="padding: 0px;"> 
                    
                    <div>
                        <%@include file="./layout/sidebar_menu.jsp" %>                        
                    </div> 
                    
                    <div id="dynamic_content" class="main-content-full pull-right">
                        <div class="" style="height: 800px;">
                            <h1>Hello from videos Page</h1>
                            <div class="container">                                    
                                    <iframe style="width: 640px; height: 360px;" src="https://www.youtube.com/embed/yYN8u90MKCg">                            
                                    </iframe>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>           
        
                    <script>
                        $(document).ready(function() {
                            $('#sidebar').removeClass('sidebar-active').addClass('sidebar-inactive'); 
                        });
                    </script>
    </body>
</html>

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
        <link type="text/css" href="<c:url value="/resources/custom/css/main_page.css" />" rel="stylesheet">
        
        <script src="<c:url value="/resources/lib/jquery-2.1.4.js" />"></script>
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script>
        
        <script src="<c:url value="/resources/custom/js/index.js"/>"></script>
    </head>

    <body>
        
        <div class="container-fluid">
            <%-- Header --%>
            <div class="row">
                <%@include file="./layout/header.jsp" %>
            </div>                      
                
            <%-- Links --%>
            <div class="row"> 
                <%@include file="./layout/navigation.jsp" %>                            
            </div>           
             
            <%-- Center --%>
            <div class="row">
                <div class="col-md-12" style="background-color: #9ad3de; height: 800px; margin-top: 2px">
                   
                    <%@include file="./layout/sidebar_menu.jsp" %>
                   

                    <div id="dynamic_content" class="main-content pull-right">
                        <div class="">
                            <h1>Creating Swipeable Side Menu For the Web</h1>
                            <p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor 
                                incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
                                exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure 
                                dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt 
                                mollit anim id est laborum."</p>
                        </div>
                    </div>

                </div>
            </div>
                        
            <%-- Footer --%>
            <%@include file="./layout/footer.jsp" %>
        </div>           
        
    </body>
    
</html>

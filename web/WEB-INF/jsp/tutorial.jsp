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
        
        <style>            

            #sidebar{
                width: 20%;
                height: 100%;
            }
            #sidebar ul li{
                font-size: 16px;
                font-weight: 500;
                line-height: 2.5em;
                border-bottom: 1px solid #ddd;
            }
            #sidebar ul li a{
                text-decoration: none;
                padding: 5px;
            }
            #sidebar ul li a i{
                margin-right: 2em;
            }
            #sidebar ul li a:hover, #sidebar ul li a:focus{
                color: #204d74;
            }
            .sidebar-active{
                display: block;
            }
            .sidebar-inactive{
                display: none;
            }
            .list-in-list{
                margin-left: 20px;
            }
            
            .main-content{
                padding: 15px;
                width: 80%;
                height: 100%;
            }
            .main-content-full{
                padding: 15px;
                width: 100%;
                height: 100%;
            }
        </style>
    </head>

    <body>
        
        <div class="container-fluid">
            <%-- Header --%>
            <div class="row">
                <div class="col-md-12"style=""> 
                    <div class="col-md-6" style="">
                        <div class="pull-left">
                            <h1>JPtutprog.kz</h1>
                            <%--<img src="<c:url value="/resources/img/logo.png"/>" width="400" height="200"  alt="programming"/> --%>                   
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="" style="margin-top: 10%">
                            
                            <a href="registration.htm">                                
                                <button class="btn btn-primary" style="float: right; margin-left: 5px">Тіркелу</button>
                            </a>
                            
                            <a href="login.htm">
                                <button class="btn btn-primary" style="float: right;">Кіру</button>                               
                            </a>
                            
                        </div>                  
                    </div>               
                </div>
            </div>                      
                
            <%-- Links --%>
            <div class="row">
                
                <div class="col-md-12" style="background-color: #89bdd3 ;margin-top: 2px; padding: 10px">
                    <div class="col-md-1">                    
                        <button class="btn btn-default left" id="btn_menu_list">
                            <i class="glyphicon glyphicon-menu-hamburger"></i>
                        </button>
                    </div>
                    <div class="col-md-9" >                
                        <ul class="list-inline right">
                            <li>
                                <a href="index.htm">Басты бет</a>
                            </li>
                            <li>
                                <a href="videolesson.htm">Видеосабақтар</a>
                            </li>
                            <li>
                                <a href="library.htm">Кітапхана</a>
                            </li>
                            <li>
                                <a href="exercise.htm">Тапсырмалар</a>
                            </li>
                            <li>
                                <a href="faq.htm">Сұрақ-жауап</a>
                            </li>
                        </ul> 
                    </div>     
                    <div class="col-md-2">
                        <button class="btn btn-primary" style="float: right">Хабарлама</button>
                    </div>
                </div>
                            
            </div>           
             
            <%-- Center --%>
            <div class="row">
                <div class="col-md-12" style="background-color: #9ad3de; height: 800px; margin-top: 2px">
                      <%@include file="./layout/nav_menu.jsp" %>
                   

                    <div id="dynamic_content" class="main-content pull-right">
                        <div class="">
                            <h1>
                                <c:out value="${themeContent.id}"/>
                                <c:out value="${themeContent.theme}"/>
                            </h1>                
                            <p>
                                <c:out value="${themeContent.themeDoc}"/>        
                            </p>
                        </div>
                    </div>

                </div>
            </div>
                        
            <%-- Footer --%>
            <div class="col-md-12" style="height: 100px">
                <p class="text-muted">This is footer. Here will be footer contexts.</p>
            </div>
        </div>           
        
    </body>
    
    <script type="text/javascript">
        $(document).ready(function() {
            $('#btn_menu_list').click( function () {
                if($('#sidebar').hasClass('sidebar-active')){
                    $('#sidebar').removeClass('sidebar-active').addClass('sidebar-inactive');
                    $('#dynamic_content').removeClass('main-content').addClass('main-content-full');
                }else{
                    $('#sidebar').removeClass('sidebar-inactive').addClass('sidebar-active');
                    $('#dynamic_content').removeClass('main-content-full').addClass('main-content');
                }
            });
        });              
    </script>
</html>

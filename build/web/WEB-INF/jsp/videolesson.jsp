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
        <link type="text/css" href="<c:url value="/resources/custom/css/videolesson_page.css" />" rel="stylesheet">
        
        <style>
            .paging-button {
                visibility: hidden;
              }

            .button-container {
                clear: both;
              }
              
            .watch-view-count {
                text-align: right;
                font-size: 16px;
                color: #666;
            }
        </style>
    </head>
    <body style="">
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
                    
                    
                    <div id="dynamic_content" class="main-content pull-right">
                        <div class="col-md-12">
                            <div id="login-container" class="pre-auth">
                                This application requires access to your YouTube account.
                                Please <a href="#" id="login-link">authorize</a> to continue.
                           </div>                                  
                        </div>
                        
                        <div class="col-md-8" style="">                                                                                                              
                            
                            <div class="" id="video-container">
                                
                            </div>
                            
                            <div class="col-md-12" id="video-information-container" 
                                style="background: #fff; border: 1px solid; border-color: #ccc; padding: 15px">
                                
                                <div class="row">
                                    <div class="col-md-12">
                                        <h4 id="video_name">Video name</h4>                                        
                                    </div>
                                </div>
                                
                                <div class="row">
                                        <div class="col-md-2" style="">
                                            <img alt="Video owner" src="<c:url value="/resources/img/skorpion.jpg"/>" height="68px" width="68px">
                                        </div>
                                    
                                        <div class="col-md-6" style="float: left">
                                            <span>Video owner</span><br>
                                            <span>Channel name</span><br>
                                            <span id="video_url">Youtube url:</span>
                                        </div> 
                                    
                                        <div class="col-md-2 watch-view-count pull-right" style="width: 20%; padding: 10px;">
                                            120 views
                                        </div>
                                </div>
                                
                                <hr style="margin-top: 0px; margin-bottom: 5px">
                                    
                                <div class="row">
                                    <div class="col-md-2 pull-right" style="text-align: right; color: #666">
                                        <span>
                                            <i class="glyphicon glyphicon-thumbs-up"></i>
                                            12
                                        </span>
                                        <span>
                                            <i class="glyphicon glyphicon-thumbs-down"></i>
                                            3
                                        </span>
                                    </div>                                            
                                </div>                                   
                                
                            </div>
                                        
                            <div class="col-md-12" id="video-information-container" 
                                 style="background: #fff; border: 1px solid; border-color: #ccc; padding: 15px; margin-top: 15px">
                                
                                <div class="row">
                                    <div class="col-md-12">
                                        <span>Uploaded on Mar 26, 2016</span>
                                        <p>Касперский компаниясы жаңа вирусты анықтады және оған сипаттама берді</p>
                                    </div>
                                </div>                            
                            </div>                       
                            
                            <div class="col-md-12" id="video-information-container" 
                                 style="background: #fff; border: 1px solid; border-color: #ccc; padding: 15px; margin-top: 15px">
                                <div class="row">
                                    <div class="col-md-12">                               
                                        <div>
                                            <ul class="list-unstyled">
                                                <li>
                                                    <p>User name and Date</p>
                                                    <p>Here will be user comment</p>
                                                </li>
                                            </ul>
                                        </div>                                        
                                        
                                        <div>
                                            <p>All Comments(0)</p>
                                            <textarea style="width: 200px; height: 50px"></textarea>
                                            <button>Cancel</button>
                                            <button>Post</button> only if user authorized!
                                        </div>
                                    </div>
                                </div>                                
                            </div>                         
                            
                        </div>
                        
                        <div class="col-md-4 pull-right" style="background: #fff; height: 100%;
                             border: 1px solid; border-color: #ccc;">
                            <div id="video-list-container" class="col-md-12">
                                
                                <ul class="list-unstyled" id="playlist_video_lists">
                                        
                                </ul>                     
                                
                                <div class="button-container">
                                        <button id="prev-button" class="paging-button" onclick="previousPage();">Previous Page</button>
                                        <button id="next-button" class="paging-button" onclick="nextPage();">Next Page</button>
                                </div>
                                                
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>  
       
        <script src="<c:url value="/resources/lib/jquery-2.1.4.js" />"></script>
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.js" />"></script>
                               
        <script src="https://apis.google.com/js/client.js?onload=googleApiClientReady"></script>
                
        <script src="<c:url value="/resources/custom/js/index.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/custom/js/auth.js"/>"></script>                                 
        <script type="text/javascript" src="<c:url value="/resources/custom/js/my_uploads.js"/>"></script>   
    </body>
</html>

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
            <div class="row" style=" padding: 0px;padding-top: 128px;">
                <div class="col-md-12" style="padding: 0px;">
                    
                    <div>
                        <%@include file="./layout/sidebar_menu.jsp" %>                        
                    </div>
                   

                    <div id="dynamic_content" class="main-content pull-right" 
                         style="padding-top: 20px; padding-bottom: 100px;">
                        <div class="" style="">
                            <h1>
                                <c:out value="${themeContent.id}"/>
                                <c:out value="${themeContent.theme}"/>
                            </h1>                
                            <p>
                                <c:out value="${themeContent.themeDoc}"/>        
                            </p>
                                         
                            <p>
                                <c:out escapeXml="" value="${content}"/>        
                            </p>
                        </div>
                        
                            <div>
                                <c:forEach items="${exercises}" var="exercise">
                                    <p>
                                        <h4>
                                            ${exercise.id}. Тапсырма: ${exercise.name}
                                        </h4>
                                        <p>${exercise.description}</p>
                                    </p>
                                    <a href="<%=request.getContextPath()%>/tutorial/${themeContent.id}/${exercise.id}/take_exercise.htm">
                                        <button type="" class="btn btn-success">Орындау</button>                                
                                    </a>
                                </c:forEach>
                            </div>
                    </div>

                </div>
            </div>
        </div>           
        
    </body>
</html>

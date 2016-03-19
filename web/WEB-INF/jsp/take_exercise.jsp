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
                <div class="col-md-12" style="background-color: #9ad3de; margin-top: 2px;">
                    <div class="col-md-4" style="margin-top: 15px; margin-bottom: 15px;">
                        <div class="form-group">
                            <textarea class="form-control" readonly rows="15" id="exercise_description">
                                Тапсырма сипаттамасы:

                                <c:out escapeXml="" value="${exercise.name}" />
                                <c:out escapeXml="" value="${exercise.description}" />
                            </textarea>
                        </div>
                    </div>
                    
                    <div class="col-md-4" style="margin-top: 15px; margin-bottom: 15px;">
                        <div class="form-group">
                            <textarea id="text_code" class="form-control" rows="15" id="code">
                                <c:out escapeXml="" value="${code}"/>
                            </textarea>
                        </div>
                            <button id="code_run" class="btn btn-primary pull-right" >Орындау</button>
                    </div>
                    
                    <div class="col-md-4" style="margin-top: 15px; margin-bottom: 15px;">
                        <div class="form-group">
                            <textarea id="text_result_code" class="form-control" readonly rows="15" id="result"></textarea>
                        </div>
                    </div>
                </div>
            </div>
                
            <%-- Footer --%>
            <%@include file="./layout/footer.jsp" %>
        </div>
        
        <script>
            $(document).ready(function() {
                
                $('#code_run').click(function (){                    
                    var code = $('#text_code').val();
                    $.ajax({
                        url: "/DiplomaProject/tutorial/{themeId}/{exerciseId}/take_exercise.htm",
                        type: "POST",
                        data: {
                            code : code
                        },
                        success: function (response){
                            $('#text_result_code').val(response);
                        }                        
                    });                          
                });
                
            });
        </script>
    </body>
</html>

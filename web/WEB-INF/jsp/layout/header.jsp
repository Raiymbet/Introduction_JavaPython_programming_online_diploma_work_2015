<%-- 
    Document   : header
    Created on : 15.02.2016, 22:05:40
    Author     : Raiymbet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-12"style=""> 
                    <div class="col-md-6" style="">
                        <div class="pull-left">
                            <h1>JPtutprog.kz</h1>
                            <%--<img src="<c:url value="/resources/img/logo.png"/>" width="400" height="200"  alt="programming"/> --%>                   
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="" style="margin-top: 10%">
                            
                            <%=session.getAttribute("userSession")%>
                            
                            <a href="<%=request.getContextPath()%>/registration.htm">                                
                                <button class="btn btn-primary" style="float: right; margin-left: 5px">Тіркелу</button>
                            </a>
                            
                            <a href="<%=request.getContextPath()%>/login.htm">
                                <button class="btn btn-primary" style="float: right;">Кіру</button>                               
                            </a>
                            
                        </div>                  
                    </div>               
                </div>
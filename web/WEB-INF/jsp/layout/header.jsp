<%-- 
    Document   : header
    Created on : 15.02.2016, 22:05:40
    Author     : Raiymbet
--%>

<%@page import="kz.model.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    Users user = (Users) session.getAttribute("userSession");
    if(user==null){
        out.println("You are not logged.");
    }else
        out.println("You logged as "+user.getEmail());
%>

<div class="col-md-12"style="background-color: #E5E5E5; padding: 5px; border-top: 1px solid; border-color: #ccc;"> 
                    
    <div class="col-md-3" style="">                        
        <div class="pull-left">
            <h2 style="margin-top: 10px;">JPtutprog.kz</h2>
            <%--<img src="<c:url value="/resources/img/logo.png"/>" width="400" height="200"  alt="programming"/> --%>                   
        </div>
    </div>
        
    <div class="col-md-9">
        <div class="" style="margin-top: 2.5%">
                            
            <%if(user==null){%>
                <a href="<%=request.getContextPath()%>/registration.htm">                                
                    <button class="btn btn-primary" style="float: right; margin-left: 5px">Тіркелу</button>
                </a>
                <a href="<%=request.getContextPath()%>/login.htm">
                    <button class="btn btn-primary" style="float: right;">Кіру</button>                               
                </a>    
            <%}%>
            <%if(user!=null){%>
                <a href="<%=request.getContextPath()%>/login.htm">
                    <button class="btn btn-primary" style="float: right; font-size: 12px; height: 30px; width: 90px;">Logout</button>                               
                </a>
            <%}%>
        </div>                  
    </div>    
        
</div>
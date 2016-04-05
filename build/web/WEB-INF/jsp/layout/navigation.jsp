<%-- 
    Document   : navigation
    Created on : 15.02.2016, 22:02:16
    Author     : Raiymbet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-12" style="padding: 5px; border-bottom: 1px solid; border-top: 1px solid; border-color: #ccc;">
                    <div class="col-md-1">                    
                        <button class="btn btn-default left" id="btn_menu_list" style="height: 30px;">
                            <i class="glyphicon glyphicon-menu-hamburger"></i>
                        </button>
                    </div>
                    <div class="col-md-9" >                
                        <ul class="list-inline right" style="height: 30px; padding: 4px; margin-bottom: 0px;">
                            <li>
                                <a href="<%=request.getContextPath()%>/index.htm">Басты бет</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/videolesson.htm">Видеосабақтар</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/library.htm">Кітапхана</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/exercise.htm">Тапсырмалар</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/faq.htm">Сұрақ-жауап</a>
                            </li>
                        </ul> 
                    </div>     
                    <div class="col-md-2">                     
                        <button class="btn btn-primary" style="float: right; height: 30px; font-size: 12px; width: 90px">Хабарлама</button>
                    </div>
                </div>

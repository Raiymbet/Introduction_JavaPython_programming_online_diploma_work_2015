<%-- 
    Document   : navigation
    Created on : 15.02.2016, 22:02:16
    Author     : Raiymbet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-12" style="background-color: #89bdd3 ;margin-top: 2px; padding: 10px">
                    <div class="col-md-1">                    
                        <button class="btn btn-default left" id="btn_menu_list">
                            <i class="glyphicon glyphicon-menu-hamburger"></i>
                        </button>
                    </div>
                    <div class="col-md-9" >                
                        <ul class="list-inline right">
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
                        <button class="btn btn-primary" style="float: right">Хабарлама</button>
                    </div>
                </div>

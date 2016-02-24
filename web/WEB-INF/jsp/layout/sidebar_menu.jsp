<%-- 
    Document   : nav_menu
    Created on : 09.02.2016, 13:14:21
    Author     : Raiymbet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <div id="sidebar" class="pull-left sidebar-active">
                        <ul class="list-unstyled">
                            <li>
                                <a href="#">
                                    Python
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Java
                                </a>
                                <ul class="list-unstyled list-in-list">
                                    <c:forEach items="${themes}" var="theme">
                                        <li>
                                            <a href="<%=request.getContextPath()%>/index/${theme.id}/tutorial.htm">
                                                <c:out value="${theme.theme}"/>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
    </div>
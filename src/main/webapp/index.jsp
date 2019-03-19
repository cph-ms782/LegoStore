<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "WEB-INF/jspf/header.jspf" %>
    </head>
    <body>
        <%@ include file = "WEB-INF/jspf/body.jspf" %>
        <div class="content">
            <div class="main">
                <ul class="sm sm-blue">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About Us </a>
                        <ul>
                            <li><a href="#">Our History</a></li>
                            <li><a href="#">Driving Directions</a></li>
                            <li><a href="#">Hours</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Our Products </a>
                        <ul>
                            <li><a href="#">Gizmos </a>
                                <ul>
                                    <li><a href="#">Gizmo Basic</a></li>
                                    <li><a href="#">Gizmo Standard</a></li>
                                    <li><a href="#">Gizmo Supreme</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Gadgets </a>
                                <ul>
                                    <li><a href="#">Gadget Basic</a></li>
                                    <li><a href="#">Gadget Standard</a></li>
                                    <li><a href="#">Gadget Supreme</a>
                                        <ul>
                                            <li><a href="#">Gadget Supreme A</a></li>
                                            <li><a href="#">Gadget Supreme B</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="#">Time Machines</a></li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
        <% String error = (String) request.getAttribute("error");
            if (error != null)
            {
                out.println("<H2>Error!!</h2>");
                out.println(error);
            }
        %>
    </body>
</html>

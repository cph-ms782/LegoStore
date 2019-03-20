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
        
        <% String error = (String) request.getAttribute("error");
            if (error != null)
            {
                out.println("<div id=\"errorInfo\">Error!!");
                out.println("<p>"+error + "<p></div>");
            }
        %>
    </body>
</html>

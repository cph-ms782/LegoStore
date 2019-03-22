<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "jspf/header.jspf" %>
    </head>
    <body>        
        <%@ include file = "jspf/body.jspf" %>
        <div id="mainInfo">Hej LEGO store ansatte <%=request.getParameter("email")%><br>
            <p> Hvad vil du lave? </p>
        </div>
    </body>
</html>

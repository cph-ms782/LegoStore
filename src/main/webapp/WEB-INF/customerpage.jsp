<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
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
        <div id="mainInfo">Hello <%=request.getParameter("email")%><br>
            <p> You are now logged in as a customer of our wonderful site. </p>
        </div>
    </body>
</html>

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
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
    </body>
</html>

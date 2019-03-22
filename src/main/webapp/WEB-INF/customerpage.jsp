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
        <div id="mainInfo">Hej <%=request.getParameter("email")%><br>
            <p> Velkommen som ny bruger på vores side.</p>
            <p> Vil du købe et nyt hus eller se tidligere ordrer.</p>
        </div>
    </body>
</html>

<%-- 
    Document   : employeepage.jsp
    Function   : showing login message
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
        <div id="mainInfo">Hej "LEGO store" ansatte <%=request.getParameter("email")%><br>
            
            <!--info for user-->
            <div id="orderInfoBox">
                <div class="orderInfo">
                    <div id="orderInfoHeader">Hvad vil du lave?<br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

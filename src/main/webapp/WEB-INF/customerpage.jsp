<%-- 
    Document   : customerpage
    Function   : showing login message
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
            Velkommen til LEGO Store.

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

<%-- 
    Document   : orderpage.jsp
    Created on : Mar, 2019
    Author     : martin bøgh
--%>

<%@page import="java.util.List"%>
<%@page import="Logic.DTO.User"%>
<%@page import="Logic.DTO.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--importing table creating and sorting javascript-->
        <script src="./js/makeTables.js"></script>

        <!--importing header declarations, css, Bootstrap, jQuery-->
        <%@ include file = "jspf/header.jspf" %>

        <!--initial setup of objects and checks-->
        <%@ include file = "jspf/init_orderPage.jspf" %>

        <!--javascript and setup of java to JS array-->
        <script>
            <%@ include file = "jspf/arrayJava2JS.jspf"%>
        </script>
        <%}%>
    </head>

    <body>
        <!--Main body html-->
        <%@ include file = "jspf/body.jspf"%>
        
        <!--Setup order info box html-->
        <%if (isOrderObject)
            {%>
        <div id="orderInfoBox">
            <div class="orderInfo">
                <p id='orderInfoHeader'>Valgt ordre</p><br>
                <p>OrdreID: <%=orderID%></p><br>
                <%if (isUserObject)
                    {%>
                <p>Køber: <%=userName%></p><br>
                <%}%>
                <br>
                <p style="text-align: center; font-size: 60px; font-style: oblique;">Stykliste</p><br>
                <ul>
                    <li>4-brik: <%=fourBricks%></li>
                    <li>2-brik: <%=twoBricks%></li>
                    <li>1-brik: <%=oneBricks%></li>
                </ul>
                <br>
                <p>Længde/bredde/højde: <%=length%>/<%=width%>/<%=height%></p><br><br>
                <p>Shipped: <%=isShipped%></p><br>
            </div>
        </div>
        <% } else
        { %>
        <div id="errorInfo">Ingen ordrer valgt<br>
        </div>
        <%}%>
    </body>
</html>

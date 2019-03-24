<%-- 
    Document   : orderpage.jsp
    Function   : presenting tables of orders. Lot of preparations are stuffed away in init_orderpage.jspf,
                 makeTables.js, tabelEvents.js and arrayJava2JS.jspf
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
        <!--importing table creating function javascript-->
        <script src="./js/makeTables.js"></script>

        <!--importing header declarations, css, Bootstrap, jQuery-->
        <%@ include file = "jspf/header.jspf" %>

        <!--initial setup of objects and checks-->
        <%@ include file = "jspf/init_orderPage.jspf" %>

        <!--setup of java to JS array-->
        <%@ include file = "jspf/arrayJava2JS.jspf"%>

        <!--      create tables. Function "createTable" is in makeTables.js. Array "orderArray" 
                  is made in "arrayJava2JS.jspf". 'mainTable' is HTML tag implanted in "body.jspf" -->
        <script>
            $(document).ready(function () // this make the JS wait for HTML to finish
            {
                header = ['Ordre Nummer', 'Afsendt'];
                createTable(header, orderArray, 'mainTable');
            }); // end ready
        </script>

        <!--setup of JS table events. Needs to be last of all scripts-->
        <%@ include file = "jspf/tableEvents.jspf"%>
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
        
      <!--if table has not been pressed inform about it-->
        <div id="orderInfoBox">
            <div class="orderInfo">
                <div id="orderInfoHeader">Ingen ordrer valgt. Tryk på tabellen<br>
                </div>
            </div>
        </div>
        <%}%>
    </body>
</html>

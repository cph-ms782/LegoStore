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
        <div id="mainInfo">Hvilket hus vil du bygge?<br>
            <form id="newHouseForm">

                <!--GET changes to POST when deployed-->
                <form name="NewOrderCommand" action="FrontController" method="GET">

                    <input type="hidden" name="command" value="FinishedOrderCommand">
                    <p>
                        <label for="width">Bredde: </label>
                        <input type="text" name="width" id="houseWidth">
                    </p>
                    <p>
                        <label for="length">Længde: </label>
                        <input type="text" name="length" id="houseLength">
                    </p>
                    <p>
                        <label for="height">Højde: </label>
                        <input type="text" name="height" id="houseHeight">
                    </p>
                    <p class="button">
                        <input type="submit" name="neworder" id="newOrderButton" value="Ordre nyt hus" >
                    </p>
                </form>
        </div>


    </body>
</html>

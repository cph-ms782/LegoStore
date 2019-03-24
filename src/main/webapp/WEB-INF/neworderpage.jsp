<%-- 
    Document   : neworderpage.jsp
    Function   : presenting form for bulding new house
    Created on : Mar, 2019
    Author     : martin bøgh
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
            <div id="newHouseDiv">
                <form id="newHouseForm">
                    <form name="NewOrderCommand" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="FinishedOrderCommand">
                        <p>
                            <label for="height">Højde: </label>
                            <input type="text" name="height" id="houseHeight">
                        </p>
                        <p>
                            <label for="width">Bredde: </label>
                            <input type="text" name="width" id="houseWidth">
                        </p>
                        <p>
                            <label for="length">Længde: </label>
                            <input type="text" name="length" id="houseLength">
                        </p>
                        <p class="button">
                            <input type="submit" name="neworder" class="btn btn-success" id="newOrderButton" value="Ordre nyt hus" >
                        </p>
                    </form>
            </div>
        </div>


    </body>
</html>

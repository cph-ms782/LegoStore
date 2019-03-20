<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="Logic.DTO.User"%>
<%@page import="Logic.DTO.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "jspf/header.jspf" %>
        <% Order order = (Order) session.getAttribute("order");
            User user = (User) session.getAttribute("user");
            String userName = null;
            boolean isOrderObject = false;
            boolean isUserObject = false;
            int length = 0;
            int width = 0;
            int height = 0;
            int orderID = 0;
            boolean isShipped = false;
            if (order != null)
            {
                length = order.getLength();
                width = order.getWidth();
                height = order.getHeight();
                orderID = order.getOrderID();
                isShipped = order.isShipped();
                isOrderObject = true;
            }
            if (user != null)
            {
                userName = user.getEmail();
                isUserObject = true;
            }

        %>
    </head>

    <body>
        <%@ include file = "jspf/body.jspf"%>
        <%if (isOrderObject)
            {%>
        <div id="orderInfo">
            <h2>Seneste ordre</h2><br>
            <h6>OrdreID: <%=orderID%></h6><br>
            <%if (isUserObject)
                {%>
            <h6>Køber: <%=userName%></h6><br>
            <%}%>
            <br>
            <h6>Length : <%=length%></h6><br>
            <h6>Width: <%=width%></h6><br>
            <h6>Height: <%=height%></h6><br>
            <h6>Shipped: <%=isShipped%></h6><br>
        </div>
        <% } else
        { %>
        <div id="mainInfo">Ingen ordrer<br>
        </div>
        <%}%>


    </body>
</html>

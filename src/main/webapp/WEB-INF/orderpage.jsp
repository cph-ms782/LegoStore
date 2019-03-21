<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="Logic.DTO.OrderList"%>
<%@page import="java.util.List"%>
<%@page import="Logic.DTO.User"%>
<%@page import="Logic.DTO.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--importing table creating and sorting javascript-->
        <script src="./js/makeTables.js"></script>

        <%@ include file = "jspf/header.jspf" %>
        <% Order order = (Order) session.getAttribute("order");
            OrderList orders = (OrderList) session.getAttribute("orders");
            User user = (User) session.getAttribute("user");
            String userName = null;
            boolean isOrderObject = false;
            boolean isOrdersObject = false;
            boolean isUserObject = false;
            int length = 0;
            int width = 0;
            int height = 0;
            int orderID = 0;
            boolean isShipped = false;
            if (orders != null)
            {
                isOrdersObject = true;
                String userID;
                String shipped;

//                make javascript array
        %>
        <script>
            $(document).ready(function ()
            {
                header = ['Order Number', 'Shipped'];

//                Dummy order array
//                orderArray = [['1', 'false'], ['2', 'false'], ['3', 'false']];

//      making JS array from java
                orderArray = [
            <% for (int i = 0; i < orders.getOrders().size(); i++)
                {
                    userID = "" + orders.getOrders().get(i).getOrderID();
                    shipped = "" + orders.getOrders().get(i).isShipped();
            %>
                [
                        '<%=userID%>'
                        , '<%= shipped%>']
            <%= i + 1 < orders.getOrders().size() ? "," : ""%>
            <%}%>
                ];

<!--creating all orders-table...-->
                createTable(header, orderArray, 'mainTable', false);
            }
            ); // end ready
        </script>
        <%}%>
        <%
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
        <
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
        <div id="errorInfo">Ingen ordrer<br>
        </div>
        <%}%>
    </body>
</html>

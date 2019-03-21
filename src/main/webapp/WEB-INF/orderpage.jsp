<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="Logic.DTO.Bricks"%>
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
            User orderUser = (User) session.getAttribute("orderUser");
            String role = (String) session.getAttribute("role");
            Bricks bricks = (Bricks) session.getAttribute("bricks");
            String userName = null;
            boolean isOrderObject = false;
            boolean isOrdersObject = false;
            boolean isOrderUserObject = false;
            boolean isUserObject = false;
            boolean isEmployee = false;
            int length = 0;
            int width = 0;
            int height = 0;
            int orderID = 0;
            int fourBricks = 0;
            int twoBricks = 0;
            int oneBricks = 0;
            boolean isShipped = false;

            if (role != null && role.equals("employee"))
            {
                isEmployee = true;
            }

            if (user != null)
            {
                userName = user.getEmail();
                isUserObject = true;
            }
            if (orderUser != null)
            {
                userName = orderUser.getEmail();
                isOrderUserObject = true;
            }
            if (bricks != null)
            {
                fourBricks = bricks.getFourBrick();
                twoBricks = bricks.getTwoBrick();
                oneBricks = bricks.getOneBrick();
            }

            if (order != null)
            {
                length = order.getLength();
                width = order.getWidth();
                height = order.getHeight();

                orderID = order.getOrderID();
                isShipped = order.isShipped();
                isOrderObject = true;
            }

            if (orders != null && orders.getOrders() != null
                    && orders.getOrders().size() > 0)
            {
                isOrdersObject = true;
                String userID;
                String shipped;

//                make javascript array
        %>
        <script>
            $(document).ready(function ()
            {
                header = ['Ordre Nummer', 'Afsendt'];

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
                createTable(header, orderArray, 'mainTable');
                $('#mainTable:has(td)').mouseover(function (e)
                {
                    $(this).css('cursor', 'crosshair');
                }); // end mouseover

                $('#mainTable:has(td)').click(function (e)
                {

                    var clickedCell = $(e.target).closest('td');
                    var clickedRow = $(e.target).closest('tr');
                    var value = clickedRow.find('td:eq(0)').text();
            <%if (isEmployee)
                { %>
                    if (clickedCell.text() == 'false')
                    {
                        var r = confirm("Er varen afsendt?");
                        if (r == true)
                        {
                            var url = 'FrontController?command=CheckOrderCommand&seeOrder=true&orderSent=true&orderID=' + value;
                            window.location.href = url;
                            return;
                        }
                    }
            <%}%>
                    var url = 'FrontController?command=CheckOrderCommand&seeOrder=true&orderID=' + value;
                    window.location.href = url;
                }); // end mouseover

            }); // end ready
        </script>
        <%}%>
    </head>

    <body>
        <%@ include file = "jspf/body.jspf"%>
        <
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

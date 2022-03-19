<html lang="en">
    <head>
        <meta name="GENERATOR" content="Microsoft FrontPage 5.0">
        <meta name="ProgId" content="FrontPage Editor.Document">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>New Page 1</title>
    </head>

    <body>
        <%@ page import="java.util.*, cart.*" %>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            Collection cartItems = cart.getCartItems();
            Iterator it = cartItems.iterator();
        %>
        <table width="100%" height="100%">
            <tr>
                <td width="100%" height="20%" bgcolor="blue">&nbsp;</td>
            </tr>
            <tr>
                <td width="100%" height="60%" bgcolor="yellow">
                    <form method="get" action="/shop/decision">
                        <table border="1" cellpadding="10" cellspacing="0" align="center">
                            <caption>Your cart</caption>
                            <tr>
                                <th>Item purchased</th>
                                <th>Quantity</th>
                                <th>Rate</th>
                                <th>Remove</th>
                            </tr>
                            <%
                                while (it.hasNext()) {
                                    CartItem cartItem = (CartItem) it.next();
                            %>
                            <tr>
                                <td><%= cartItem.getItem().getDescription() %></td>
                                <td align="center"><input type="text" name="T<%= cartItem.getCartItemId() %>" size="1" value="<%= cartItem.getQuantity() %>"></td>
                                <td>INR <%= cartItem.getItem().getPrice() %></td>
                                <td align="center"><input type="checkbox" name="<%= cartItem.getCartItemId() %>" value="ON"></td>
                            </tr>
                            <% } %>
                            <tr>
                                <td colspan="2">Total amount</td>
                                <td>INR <%= cart.getCartValue() %></td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <input type="submit" value="Update Cart" name="update">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="submit" value="Shop More" name="shop">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="submit" value="Freeze Cart" name="freeze">
                                </td>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>
            <tr>
                <td width="100%" height="20%" bgcolor="blue">&nbsp;</td>
            </tr>
        </table>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
    </body>
</html>
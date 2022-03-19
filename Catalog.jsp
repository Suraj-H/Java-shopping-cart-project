<%@ page import="java.util.*, cart.Item" %>

<html>
    <table width="100%" height="100%">
        <tr>
            <td width="100%" height="20%" bgcolor="blue">&nbsp;</td>
        </tr>
        <tr>
            <td width="100%" height="60%" bgcolor="yellow">
                <form name="loginForm" method="post" action="/shop/addItems">
                    <table align="center">
                        <caption>Catalog</caption>
                        <tr>
                            <th>Image</th>
                            <th>Description</th>
                            <th>Rate</th>
                            <th>&nbsp;</th>
                        </tr>
                        <%
                            Collection items = (Collection) request.getAttribute("items");
                            Iterator it = items.iterator();
                            while (it.hasNext()) {
                                Item item = (Item) it.next();
                        %>
                        <tr>
                            <td cellpadding="30"><img src="<%= item.getImagePath() %>" width="60" height="50"></td>
                            <td cellpadding="30"><B><%= item.getDescription() %></B></td>
                            <td cellpadding="30">INR <%= item.getPrice() %></td>
                            <td>&nbsp;<input type="checkbox" name="item<%= item.getId() %>" value="ON"></td>
                        </tr>
                        <% } %>
                        <tr>
                            <td cellpadding="30" colspan="4" align="center"><input type="submit" name="submit" value="Purchase" /></td>
                        </tr>
                    </table>
                </form>
            </td>
        </tr>
        <tr>
            <td width="100%" height="20%" bgcolor="blue">&nbsp;</td>
        </tr>
    </table>
</html>
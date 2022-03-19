package cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class AddItemsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ItemDAO itemDAO = new ItemDAO();
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        try {
            int itemCount = itemDAO.getItemCount();
            for (int i = 1; i <= itemCount; ++i) {
                String s = request.getParameter("item" + i);
                if (s != null) {
                    Item item = itemDAO.getItem(i);
                    CartItem cartItem = new CartItem("cartItem" + item.getId(), item, 1);
                    cart.addCartItem(cartItem);
                }
            }
            response.sendRedirect("/shop/DisplayCart.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            writer.println(e);
        }
    }
}
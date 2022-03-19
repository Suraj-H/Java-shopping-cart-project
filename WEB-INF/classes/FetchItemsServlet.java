package cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

public class FetchItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            ItemDAO itemDAO = new ItemDAO();
            Collection<Item> items = itemDAO.getAllItems();
            request.setAttribute("items", items);
            request.getRequestDispatcher("/Catalog.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            writer.println(e);
        }
    }
}
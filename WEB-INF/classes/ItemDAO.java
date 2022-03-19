package cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class ItemDAO {
    Connection connection;

    public ItemDAO() { }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart", "root", "surajh");
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Collection<Item> getAllItems() throws ClassNotFoundException, SQLException {
        Vector<Item> items = new Vector<Item>();
        getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from Items");
        while (resultSet.next()) {
            Item item = new Item();
            item.setId(resultSet.getInt(1));
            item.setName(resultSet.getString(2));
            item.setImagePath(resultSet.getString(3));
            item.setDescription(resultSet.getString(4));
            item.setPrice(resultSet.getDouble(5));
            items.addElement(item);
        }
        resultSet.close();
        statement.close();
        closeConnection();
        return items;
    }

    public Item getItem(final int itemId) throws ClassNotFoundException, SQLException {
        Item item = new Item();
        getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from Items where itemId = " + itemId);
        if (resultSet.next()) {
            item.setId(resultSet.getInt(1));
            item.setName(resultSet.getString(2));
            item.setImagePath(resultSet.getString(3));
            item.setDescription(resultSet.getString(4));
            item.setPrice(resultSet.getDouble(5));
        }
        resultSet.close();
        statement.close();
        closeConnection();
        return item;
    }

    public int getItemCount() throws ClassNotFoundException, SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select count(*) from items");
        resultSet.next();
        int itemCount = resultSet.getInt(1);
        resultSet.close();
        statement.close();
        closeConnection();
        return itemCount;
    }
}
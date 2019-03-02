package servlets;

import database.DBConnector;

import java.sql.*;
import java.util.Scanner;

public class CoffeeShops {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection conn = new DBConnector().getConn();

        try {
            addOne(conn);
            selectAll(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Example of inserting data
     *
     * If this error comes up, update your 'id' column to use auto-increment
     *    java.sql.SQLException: Field 'id' doesn't have a default value
     *
     * @param conn
     * @throws SQLException
     */
    private static void addOne(Connection conn) throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's the name of the coffee shop?");
        String name = keyboard.nextLine();

        String insertSql = "INSERT INTO coffee_shops (name) VALUES (?)";

        PreparedStatement statement = conn.prepareStatement(insertSql);
        statement.setString(1, name);
        int numResultsInserted = statement.executeUpdate();
    }

    /**
     * Example of querying data and printing it to the screen
     *
     * @param conn
     * @throws SQLException
     */
    private static void selectAll(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM coffee_shops");

        while(resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
    }
}

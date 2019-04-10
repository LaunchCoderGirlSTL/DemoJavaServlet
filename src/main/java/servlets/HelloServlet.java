package servlets;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import database.DBConnector;


public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM students");
            writer.print("Hello, ");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
                writer.print(resultSet.getString("name") + ", ");
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            writer.print("Something went wrong while connecting to the database. Check the server log for details");
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        PreparedStatement statement = null;
        String sql = "INSERT INTO students (name) values (?)";
        String name = request.getParameter("studentName");
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            int i=statement.executeUpdate();
            writer.print(i+" records inserted");


        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            writer.print("Something went wrong while connecting to the database. Check the server log for details");
        }
    }

}

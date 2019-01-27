package servlets;

import database.DBConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class RedirectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<String> names = new ArrayList<String>();
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM students");
            while(resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
            request.setAttribute("names", names);
            RequestDispatcher dispatcher = request.getRequestDispatcher("redirected.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}

package servlets;

import database.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


public class ImageSampleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<String> captions = Arrays.asList("Alpaca Punch",
                "Top of the food chain",
                "I'm on Break!");
        request.setAttribute("message", "Hello Test!");
        request.setAttribute("captions", captions);
        request.getRequestDispatcher("samples.jsp").forward(request, response);

    }

}

package servlets;

import database.DBConnector;
import model.ImageRecord;

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

        List<ImageRecord> captions = Arrays.asList(
                new ImageRecord("http://bit.ly/cgidb_alpaca", "Alpaca Punch", true),
                new ImageRecord("http://bit.ly/cgidb_dragon1", "Top of the food chain", true),
                new ImageRecord("http://bit.ly/cgidb_goats", "I'm on Break!"));
        request.setAttribute("results", captions);
        request.getRequestDispatcher("samples.jsp").forward(request, response);

    }

}

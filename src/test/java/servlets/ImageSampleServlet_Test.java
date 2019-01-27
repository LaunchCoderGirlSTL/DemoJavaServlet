package servlets;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ImageSampleServlet_Test {

    @Test
    public void doPost() throws Exception{

        //Set up some expected values
        String expectedTarget = "samples.jsp";
        List<String> expectedCaptions = Arrays.asList("Alpaca Punch",
                "Top of the food chain",
                "I'm on Break!");

        //Mocks are intermediate unit testing, but necessary to test HttpServletRequest.
        //We'll explain later...
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        when(req.getRequestDispatcher(expectedTarget)).thenReturn(mock(RequestDispatcher.class));

        //call the method under test
        new ImageSampleServlet().doPost(req, resp);
        verify(req).setAttribute("captions", expectedCaptions);  //more mocks, ignore this.

    }
}

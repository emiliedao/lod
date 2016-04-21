package servlet;

import data.FelidaeData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by emiliedao on 4/14/16.
 */
@WebServlet("/felidae")
public class FelidaeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Get list of felidae
        FelidaeData felidaeData = new FelidaeData();

        HashMap<String, String> species = felidaeData.getSpecies();
        request.setAttribute("names", species);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/felidae.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}

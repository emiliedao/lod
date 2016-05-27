package servlet;

import com.google.gson.Gson;
import dao.DaoFactory;
import dao.SpeciesDao;
import entity.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by emiliedao on 5/27/16.
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String searchValue = request.getParameter("term");
//        System.out.println("Data from ajax call " + searchValue);
//
//        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
//        List<String> species = speciesDao.search(searchValue);
//
//        String searchList = new Gson().toJson(species);
//        System.out.println(searchList);
//        response.getWriter().write(searchList);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String searchValue = request.getParameter("searchValue");
//        System.out.println("Data from ajax call " + searchValue);
//
//        SpeciesDao speciesDao = DaoFactory.getSpeciesDao();
//        List<String> species = speciesDao.search(searchValue);
//
//        String searchList = new Gson().toJson(species);
//        response.setContentType("text/plain");
////        System.out.println(searchList);
//        response.getWriter().write(searchList);


    }

}

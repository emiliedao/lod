package servlet;

import dao.ConservationStatusDao;
import dao.DaoFactory;
import entity.ConservationStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by emiliedao on 5/16/16.
 */
@WebServlet("/conservationStatus")
public class ConservationStatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConservationStatusDao conservationStatusDao = DaoFactory.getConservationStatusDao();
        List<ConservationStatus> conservationStatus = conservationStatusDao.findAll(ConservationStatus.class);
        request.setAttribute("conservationStatus", conservationStatus);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/conservationStatus.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package servlet;

import data.news.AlchemyNews;
import data.news.GuardianNews;
import data.news.NYNews;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by emiliedao on 5/19/16.
 */
@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String currentMonth = "";
        if (month <= 9) {
            currentMonth = "0";
        }
        currentMonth += Integer.toString(month);

        String source = request.getParameter("source");

        if (source == null) {
            source = "guardian";
        }

        request.setAttribute("source", source);
        System.out.println("Source : " + source);

//        The Guardian news
        if (source.equals("guardian")) {
            String guardianAPI = "http://content.guardianapis.com/search?q=endangered%20AND%20animals&tag=environment/wildlife&from-date=2016-" + currentMonth + "-01&show-blocks=all&api-key=25b9008f-4376-4cd1-b03e-5fa5fcc03e24";

            ArrayList<GuardianNews> guardianNewsList = new ArrayList<GuardianNews>();

            try {
                String jsonString = IOUtils.toString(new URL(guardianAPI));
                JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
                JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
                JSONArray results = (JSONArray) jsonResponse.get("results");

                for (int i = 0; i < results.size(); i++) {
                    JSONObject o = (JSONObject) results.get(i);
                    guardianNewsList.add(new GuardianNews(o));
                }

                request.setAttribute("listNews", guardianNewsList);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

//        New York Times news
        else if (source.equals("ny")) {
            System.out.println("New York");

            String NY_API = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=955b55cdf6ec4473b89ead03b0a63a81&q=endangered+animals&begin_date=2016" + currentMonth + "01";

            ArrayList<NYNews> nyNewsList = new ArrayList<NYNews>();
            try {
                String jsonString = IOUtils.toString(new URL(NY_API));
                JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
                JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
                JSONArray docs = (JSONArray) jsonResponse.get("docs");

                for (int i = 0; i < docs.size(); i++) {
                    JSONObject o = (JSONObject) docs.get(i);
                    nyNewsList.add(new NYNews(o));
                }

                request.setAttribute("listNews", nyNewsList);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        Others : Alchemy DataNews
        else if (source.equals("alchemy")) {
            String alchemyAPI = "https://access.alchemyapi.com/calls/data/GetNews?apikey=c07647cb998ab149f0edb330e3289c277ab7e4b0&return=enriched.url.title,enriched.url.url,enriched.url.author,enriched.url.publicationDate&start=1462060800&end=1463698800&q.enriched.url.text=endangered%20animals&q.enriched.url.taxonomy.taxonomy_.label=science&count=25&outputMode=json";
            ArrayList<AlchemyNews> alchemyNewsList = new ArrayList<AlchemyNews>();

            try {
                String jsonString = IOUtils.toString(new URL(alchemyAPI));
                JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
                JSONObject result = (JSONObject) jsonObject.get("result");
                JSONArray docs = (JSONArray) result.get("docs");

                for (int i = 0; i < docs.size(); i++) {
                    JSONObject o = (JSONObject) docs.get(i);
                    alchemyNewsList.add(new AlchemyNews(o));
                }

                request.setAttribute("listNews", alchemyNewsList);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/news.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

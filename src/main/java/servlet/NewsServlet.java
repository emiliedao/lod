package servlet;

import data.news.*;
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
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by emiliedao on 5/19/16.
 */
@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    /**
     * GET METHOD
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Get category if the parameter is specified
        String category = request.getParameter("category");
        NewsCategory newsCategory = null;
//        Get news by category
        if (category != null) {
            newsCategory = NewsCategory.valueOf(category.toUpperCase());
            ArrayList<News> listNews = getNewsByCategory(newsCategory);
            request.setAttribute("listNews", listNews);
        }

        else {
            String source = request.getParameter("source");

//        Display The Guardian news by default
            if (source == null) {
                source = "guardian";
            }

            request.setAttribute("source", source);

            String currentMonth = getCurrentMonth();

//        The Guardian news
            if (source.equals("guardian")) {
                String guardianAPI = "http://content.guardianapis.com/search"
                        + "?q=endangered%20AND%20animals"
                        + "&tag=environment/wildlife"
                        + "&from-date=2016-" + currentMonth + "-" + "01"
                        + "&show-blocks=all"
                        + "&api-key=25b9008f-4376-4cd1-b03e-5fa5fcc03e24";

                ArrayList<GuardianNews> guardianNewsList = getGuardianNews(guardianAPI);
                request.setAttribute("listNews", guardianNewsList);

            }

//        New York Times news
            else if (source.equals("ny")) {
                String NY_API = "https://api.nytimes.com/svc/search/v2/articlesearch.json"
                        +"?api-key=955b55cdf6ec4473b89ead03b0a63a81"
                        +"&q=endangered+animals"
                        +"&begin_date=2016" + currentMonth + "01";

                ArrayList<NYNews> nyNewsList = getNYNews(NY_API);
                request.setAttribute("listNews", nyNewsList);
            }

//        Others : Alchemy DataNews
            else if (source.equals("alchemy")) {
                Date currentDate = new Date();
                String currentTimestamp = String.valueOf(currentDate.getTime()/1000);
                String monthTimestamp = getBeginningMonthTimestamp();


                String alchemyAPI = "https://access.alchemyapi.com/calls/data/GetNews"
                        + "?apikey=c07647cb998ab149f0edb330e3289c277ab7e4b0"
                        + "&return=enriched.url.title,enriched.url.url,enriched.url.author,enriched.url.publicationDate"
                        + "&start=" + monthTimestamp
                        + "&end=" + currentTimestamp
                        + "&q.enriched.url.cleanedTitle=endangered%20species"
                        + "&q.enriched.url.enrichedTitle.taxonomy.taxonomy_.label=science"
                        +"&count=30"
                        +"&outputMode=json";

                ArrayList<AlchemyNews> alchemyNewsList = getAlchemyNews(alchemyAPI);
                request.setAttribute("listNews", alchemyNewsList);
            }

        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/news.jsp").forward(request, response);
    }

    /**
     * POST METHOD
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        request.setAttribute("search", search);
        String keywords = search.replace(" ", "%20");

        String source = request.getParameter("source");
        request.setAttribute("source", source);

        String currentMonth = getCurrentMonth();

        if (source.equals("guardian")) {
            String guardianAPI = "http://content.guardianapis.com/search"
                    + "?q=" + keywords
                    + "&tag=environment/wildlife"
                    + "&from-date=2016-" + currentMonth + "-" + "01"
                    + "&show-blocks=all"
                    + "&api-key=25b9008f-4376-4cd1-b03e-5fa5fcc03e24";

            ArrayList<GuardianNews> guardianNewsList = getGuardianNews(guardianAPI);
            request.setAttribute("listNews", guardianNewsList);
        }

        else if (source.equals("ny")) {
            String NY_API = "https://api.nytimes.com/svc/search/v2/articlesearch.json"
                    +"?api-key=955b55cdf6ec4473b89ead03b0a63a81"
                    +"&q=" + URLEncoder.encode(search, "UTF-8")
                    +"&begin_date=2016" + currentMonth + "01";

            ArrayList<NYNews> nyNewsList = getNYNews(NY_API);
            request.setAttribute("listNews", nyNewsList);
        }

        else if (source.equals("alchemy")) {
            Date currentDate = new Date();
            String currentTimestamp = String.valueOf(currentDate.getTime()/1000);
            String monthTimestamp = getBeginningMonthTimestamp();


            String alchemyAPI = "https://access.alchemyapi.com/calls/data/GetNews"
                    + "?apikey=c07647cb998ab149f0edb330e3289c277ab7e4b0"
                    + "&return=enriched.url.title,enriched.url.url,enriched.url.author,enriched.url.publicationDate"
                    + "&start=" + monthTimestamp
                    + "&end=" + currentTimestamp
                    + "&q.enriched.url.cleanedTitle=" + keywords
                    + "&q.enriched.url.enrichedTitle.taxonomy.taxonomy_.label=science"
                    +"&count=30"
                    +"&outputMode=json";

            ArrayList<AlchemyNews> alchemyNewsList = getAlchemyNews(alchemyAPI);
            request.setAttribute("listNews", alchemyNewsList);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/news.jsp").forward(request, response);

    }

    /**
     * Call Guardian News API and get the monthly news
     * @param APIcall the path for API call
     * @return the list of news
     */
    private ArrayList<GuardianNews> getGuardianNews(String APIcall) {
        ArrayList<GuardianNews> guardianNewsList = new ArrayList<GuardianNews>();

        try {
            String jsonString = IOUtils.toString(new URL(APIcall));
            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
            JSONArray results = (JSONArray) jsonResponse.get("results");

            for (int i = 0; i < results.size(); i++) {
                JSONObject o = (JSONObject) results.get(i);
                GuardianNews guardianNews = new GuardianNews(o);
                guardianNews.formatDate();
                guardianNewsList.add(guardianNews);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return guardianNewsList;
    }

    /**
     * Call The New York Times API to get the news
     * @param APIcall the path for API call
     * @return the list of news
     */
    private ArrayList<NYNews> getNYNews(String APIcall) {
        ArrayList<NYNews> nyNewsList = new ArrayList<NYNews>();
        try {
            String jsonString = IOUtils.toString(new URL(APIcall));
            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONObject jsonResponse = (JSONObject) jsonObject.get("response");
            JSONArray docs = (JSONArray) jsonResponse.get("docs");

            for (int i = 0; i < docs.size(); i++) {
                JSONObject o = (JSONObject) docs.get(i);
                NYNews nyNews = new NYNews(o);
                nyNews.formatDate();
                nyNewsList.add(nyNews);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nyNewsList;
    }

    /**
     * Call Alchemy DataNews API to get the news
     * @param APIcall the path for API call
     * @return the list of news
     */
    private ArrayList<AlchemyNews> getAlchemyNews(String APIcall) {

        ArrayList<AlchemyNews> alchemyNewsList = new ArrayList<AlchemyNews>();

        try {

            String jsonString = IOUtils.toString(new URL(APIcall));
            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
            JSONObject result = (JSONObject) jsonObject.get("result");
            JSONArray docs = (JSONArray) result.get("docs");

            if (docs != null) {
                for (int i = 0; i < docs.size(); i++) {
                    JSONObject o = (JSONObject) docs.get(i);
                    AlchemyNews alchemyNews = new AlchemyNews(o);
                    alchemyNews.formatDate();
                    alchemyNewsList.add(alchemyNews);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return alchemyNewsList;
    }

    /**
     *
     * @return current month
     */
    private String getCurrentMonth() {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String currentMonth = "";
        if (month <= 9) {
            currentMonth = "0";
        }
        currentMonth += Integer.toString(month);
        return currentMonth;
    }

    /**
     * Get the timestamp corresponding to the first day of the current month
     * @return the timestamp
     */
    private String getBeginningMonthTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date monthDate = null;
        try {
            monthDate = sdf.parse("01/" + getCurrentMonth() + "/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.valueOf(monthDate.getTime()/1000);
    }

    private ArrayList<News> getNewsByCategory(NewsCategory category) {
        ArrayList<News> news = new ArrayList<News>();

        String guardianAPI = "http://content.guardianapis.com/search"
                + "?show-blocks=all"
                + "&api-key=25b9008f-4376-4cd1-b03e-5fa5fcc03e24";

        String NY_API = "https://api.nytimes.com/svc/search/v2/articlesearch.json"
                +"?api-key=955b55cdf6ec4473b89ead03b0a63a81";

        String alchemyAPI = "https://access.alchemyapi.com/calls/data/GetNews"
                + "?apikey=c07647cb998ab149f0edb330e3289c277ab7e4b0"
                + "&return=enriched.url.title,enriched.url.url,enriched.url.author,enriched.url.publicationDate"
                + "&q.enriched.url.enrichedTitle.taxonomy.taxonomy_.label=science"
                +"&count=5"
                +"&outputMode=json";

        switch (category) {
            case ENDANGERED_SPECIES:
                guardianAPI += "&q=endangered%20AND%20species";
                NY_API += "&q=endangered+species";
                alchemyAPI += "&q.enriched.url.cleanedTitle=endangered%20species";
                break;

            case WILDLIFE:
                guardianAPI += "&tag=environment/wildlife";
                NY_API += "&q=wildlife";
                alchemyAPI += "&q.enriched.url.cleanedTitle=wildlife";
                break;

            case ANIMALS:
                guardianAPI += "&q=animals";
                NY_API += "&q=animals";
                alchemyAPI += "&q.enriched.url.cleanedTitle=animals";
                break;

            case MAMMALS:
                guardianAPI += "&q=mammals";
                NY_API += "&q=mammals";
                alchemyAPI += "&q.enriched.url.cleanedTitle=mammals";
                break;

            case ENVIRONMENT:
                guardianAPI += "&q=environment";
                NY_API += "&q=environment";
                alchemyAPI += "&q.enriched.url.cleanedTitle=environment";
                break;

            case GLOBAL_WARMING:
                guardianAPI += "&q=global20AND%20warming";
                NY_API += "&q=global+warming";
                alchemyAPI += "&q.enriched.url.cleanedTitle=global%20warming";
                break;

            case PLANET:
                guardianAPI += "&q=planet";
                NY_API += "&q=planet";
                alchemyAPI += "&q.enriched.url.cleanedTitle=planet";
                break;

            case CLIMATE_CHANGE:
                guardianAPI += "&tag=environment/climate-change";
                NY_API += "&q=climate+change";
                alchemyAPI += "&q.enriched.url.cleanedTitle=climate%20change";
                break;
        }

        ArrayList<GuardianNews> guardianNews = getGuardianNews(guardianAPI);
        ArrayList<NYNews> nyNews = getNYNews(NY_API);
        ArrayList<AlchemyNews> alchemyNews = getAlchemyNews(alchemyAPI);

        news.addAll(guardianNews);
        news.addAll(nyNews);
        news.addAll(alchemyNews);

        return news;
    }
}

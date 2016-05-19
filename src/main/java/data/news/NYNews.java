package data.news;

import data.news.News;
import org.json.simple.JSONObject;

/**
 * Created by emiliedao on 5/19/16.
 */
public class NYNews extends News {
    public NYNews(JSONObject o) {
        webUrl = (String) o.get("web_url");
        summary = (String) o.get("snippet");
        publicationDate = (String) o.get("pub_date");

        JSONObject headline = (JSONObject) o.get("headline");
        title = (String) headline.get("main");

    }
}

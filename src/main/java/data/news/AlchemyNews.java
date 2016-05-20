package data.news;

import org.json.simple.JSONObject;

/**
 * Created by emiliedao on 5/19/16.
 */
public class AlchemyNews extends News {
    public AlchemyNews(JSONObject o) {

        JSONObject source = (JSONObject) o.get("source");
        JSONObject enriched = (JSONObject) source.get("enriched");

        JSONObject  url = (JSONObject) enriched.get("url");
        author = (String) url.get("author");
        webUrl = (String) url.get("url");
        title = (String) url.get("title");
        JSONObject date = (JSONObject) url.get("publicationDate");
        publicationDate = (String) date.get("date");
    }

    @Override
    public void formatDate() {
        String year = publicationDate.substring(0, 4);
        String month = publicationDate.substring(4, 6);
        String day = publicationDate.substring(6, 8);

        publicationDate = year + "-" + month + "-" + day;
    }
}

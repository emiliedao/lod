package data.news;

import org.json.simple.JSONObject;

/**
 * Created by emiliedao on 5/19/16.
 */
public class AlchemyNews extends News {
    public AlchemyNews(JSONObject o) {

        JSONObject source = (JSONObject) o.get("source");
        JSONObject enriched = (JSONObject) source.get("enriched");
        title = (String) enriched.get("title");
        webUrl = (String) enriched.get("url");

        JSONObject  url = (JSONObject) enriched.get("url");
        author = (String) url.get("author");
        publicationDate = (String) url.get("date");

    }
}

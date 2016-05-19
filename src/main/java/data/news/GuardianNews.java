package data.news;

import data.news.News;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by emiliedao on 5/19/16.
 */
public class GuardianNews extends News {

    public GuardianNews(JSONObject o) {
        title = (String) o.get("webTitle");
        publicationDate = (String) o.get("webPublicationDate");
        webUrl = (String) o.get("webUrl");

        JSONObject blocks = (JSONObject) o.get("blocks");
        JSONArray bodyArray = (JSONArray) blocks.get("body");
        JSONObject body = (JSONObject) bodyArray.get(0);
        String text[] = body.get("bodyTextSummary").toString().split("\\. ");

        summary = "";
        if (text.length >=2) {
            summary += text[0] + ". " + text[1] + ". " + text[2] + ". ";
        }

        bodyHtml = (String) body.get("bodyHtml");
    }
}

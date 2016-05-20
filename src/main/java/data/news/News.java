package data.news;

/**
 * Created by emiliedao on 5/19/16.
 */
public abstract class News {
    protected String title;
    protected String publicationDate;
    protected String author;
    protected String webUrl;
    protected String summary;
    protected String bodyHtml;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "News{" +
                ", title='" + title + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", summary='" + summary + '\'' +
                ", bodyHtml='" + bodyHtml + '\'' +
                '}';
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public abstract void formatDate();
}

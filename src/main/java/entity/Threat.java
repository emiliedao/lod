package entity;

/**
 * Created by emiliedao on 4/28/16.
 */
public class Threat {
    private int id;
    private String title;

    public Threat() {
    }

    public Threat(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

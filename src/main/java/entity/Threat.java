package entity;

import javax.persistence.*;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "threat")
public class Threat {

    @Id
    private int id;

    @Column(name = "title")
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

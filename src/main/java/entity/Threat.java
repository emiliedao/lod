package entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "threat")
public class Threat {

    @Id
    @Column(name = "threat_id")
    @GeneratedValue
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "threats")
    private Set<Species> species;

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

    @Override
    public String toString() {
        return "Threat{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

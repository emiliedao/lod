package entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "measure")
public class Measure {
    @Id
    @Column(name = "measure_id")
    @GeneratedValue
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "measures")
    private Set<Species> species;

    public Measure() {
    }

    public Measure(int id, String title) {
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

    public Set<Species> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Species> species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

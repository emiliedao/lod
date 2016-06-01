package entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "country_id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "countries")
    private Set<Species> species;

    public Country() {
    }

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

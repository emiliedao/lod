package entity;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "species_lives_in", joinColumns = @JoinColumn(name = "country_id"))
    @MapKeyJoinColumn(name = "species_id")
    @Column(name = "count")
    private Map<Species, Integer> species;

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
}

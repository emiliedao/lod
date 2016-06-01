package entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "habitat")
public class Habitat {

    @Id
    @Column(name = "habitat_id")
    @GeneratedValue
    private int id;

    @Column(name = "label")
    private String label;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "habitats")
    private Set<Species> species;


    public Habitat() {
    }

    public Habitat(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Species> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Species> species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}

package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "conservationStatus")
public class ConservationStatus {
    @Id
    @Column(name = "conservationStatus_id")
    @GeneratedValue
    private int id;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "conservationStatus")
    private List<Species> species;

    public ConservationStatus() {
    }

    public ConservationStatus(int id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

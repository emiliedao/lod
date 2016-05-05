package entity;

import javax.persistence.*;
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

    @Column(name = "type")
    private String type;


    public Habitat() {
    }

    public Habitat(int id, String label, String type) {
        this.id = id;
        this.label = label;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

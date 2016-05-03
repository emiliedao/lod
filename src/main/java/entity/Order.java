package entity;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "order")
public class Order {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private BiologyClass biologyClass;

    @OneToMany(mappedBy = "order")
    private ArrayList<Family> families;

    public Order() {
    }

    public Order(int id, String name, String description, byte[] image, BiologyClass biologyClass) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.biologyClass = biologyClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BiologyClass getBiologyClass() {
        return biologyClass;
    }

    public void setBiologyClass(BiologyClass biologyClass) {
        this.biologyClass = biologyClass;
    }
}

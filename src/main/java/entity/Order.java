package entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "class_id")
    private BiologyClass biologyClass;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private Set<Family> families;

    public Order() {
    }

    public Order(String name, String description, String image, BiologyClass biologyClass) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.biologyClass = biologyClass;
    }

    public Order(int id, String name, String description, String image, BiologyClass biologyClass) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BiologyClass getBiologyClass() {
        return biologyClass;
    }

    public void setBiologyClass(BiologyClass biologyClass) {
        this.biologyClass = biologyClass;
    }

    public Set<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Set<Family> families) {
        this.families = families;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", biologyClass=" + biologyClass +
                ", families=" + families +
                '}';
    }
}

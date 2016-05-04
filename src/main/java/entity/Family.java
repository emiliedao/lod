package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "family")
public class Family {
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
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "family")
    private List<Species> species;

    public Family() {
    }

    public Family(int id, String name, String description, byte[] image, Order order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

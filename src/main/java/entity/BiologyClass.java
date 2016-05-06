package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "class")
public class BiologyClass {
    @Id
    @GeneratedValue
    @Column(name = "class_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "biologyClass", cascade = CascadeType.ALL)
    private List<Order> orders;

    public BiologyClass() {
    }

    public BiologyClass(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        String str = "BiologyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", orders={" ;

        for (Order order : orders) {
            str += order.getName();
            if (orders.indexOf(order) != orders.size() - 1)
                str += ", ";
        }
        str += "} }";
        return str;
    }
}

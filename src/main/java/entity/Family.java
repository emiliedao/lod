package entity;

/**
 * Created by emiliedao on 4/28/16.
 */
public class Family {
    private int id;
    private String name;
    private String description;
    private byte[] image;
    private Order order;

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

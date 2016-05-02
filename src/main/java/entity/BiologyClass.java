package entity;

import javax.persistence.*;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "class")
public class BiologyClass {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @Lob
    private byte[] image;

    public BiologyClass() {
    }

    public BiologyClass(int id, String name, String description, byte[] image) {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

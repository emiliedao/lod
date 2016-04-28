package entity;

/**
 * Created by emiliedao on 4/28/16.
 */
public class ConservationStatus {
    private int id;
    private String label;
    private String description;

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

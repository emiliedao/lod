package entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by emiliedao on 4/28/16.
 */
public class Species {
    private int id;
    private String name;
    private String scientificName;
    private String description;
    private String comment;
    private int count;
    private byte[] image;
    private Order order;
    private ConservationStatus conservationStatus;
    private ArrayList<Habitat> habitats;
    private ArrayList<Threat> threats;
    private ArrayList<Measure> measures;
    private HashMap<Country, Integer> countries;

    public Species() {
    }

    public Species(int id, String name, String scientificName, String description, String comment, int count, byte[] image, Order order, ConservationStatus conservationStatus, ArrayList<Habitat> habitats, ArrayList<Threat> threats, ArrayList<Measure> measures, HashMap<Country, Integer> countries) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.description = description;
        this.comment = comment;
        this.count = count;
        this.image = image;
        this.order = order;
        this.conservationStatus = conservationStatus;
        this.habitats = habitats;
        this.threats = threats;
        this.measures = measures;
        this.countries = countries;
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

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public ConservationStatus getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(ConservationStatus conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(ArrayList<Habitat> habitats) {
        this.habitats = habitats;
    }

    public ArrayList<Threat> getThreats() {
        return threats;
    }

    public void setThreats(ArrayList<Threat> threats) {
        this.threats = threats;
    }

    public ArrayList<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(ArrayList<Measure> measures) {
        this.measures = measures;
    }

    public HashMap<Country, Integer> getCountries() {
        return countries;
    }

    public void setCountries(HashMap<Country, Integer> countries) {
        this.countries = countries;
    }
}

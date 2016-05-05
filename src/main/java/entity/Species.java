package entity;

import java.util.List;
import java.util.Map;
import javax.persistence.*;

/**
 * Created by emiliedao on 4/28/16.
 */
@Entity
@Table(name = "species")
public class Species {

    @Id
    @Column(name = "species_id")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "scientificName")
    private String scientificName;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @Column(name = "count")
    private int count;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "family_id")
    private Family family;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "conservationStatus_id")
    private ConservationStatus conservationStatus;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "species_has_habitat",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "habitat_id"))
    private List<Habitat> habitats;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "species_is_threatened_by",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "threat_id"))
    private List<Threat> threats;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "species_is_concerned_by",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "measure_id"))
    private List<Measure> measures;

    @ElementCollection
    @CollectionTable(name = "species_lives_in", joinColumns = @JoinColumn(name = "species_id"))
    @MapKeyJoinColumn(name = "country_id")
    @Column(name = "count")
    private Map<Country, Integer> countries;

    public Species() {
    }

    public Species(int id, String name, String scientificName, String description, String comment, int count, byte[] image) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.description = description;
        this.comment = comment;
        this.count = count;
        this.image = image;
    }

    public Species(int id, String name, String scientificName, String description, String comment, int count, byte[] image, Family family, ConservationStatus conservationStatus,List<Habitat> habitats, List<Threat> threats, List<Measure> measures, Map<Country, Integer> countries) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.description = description;
        this.comment = comment;
        this.count = count;
        this.image = image;
        this.family = family;
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public ConservationStatus getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(ConservationStatus conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(List<Habitat> habitats) {
        this.habitats = habitats;
    }

    public List<Threat> getThreats() {
        return threats;
    }

    public void setThreats(List<Threat> threats) {
        this.threats = threats;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }

    public Map<Country, Integer> getCountries() {
        return countries;
    }

    public void setCountries(Map<Country, Integer> countries) {
        this.countries = countries;
    }
}

package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Models")
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"name", "year"}))
public class Model {



    @Id
   // @Column(name = "model_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int model_ID;

    @Column(length = 35)
    private String name;

    //@Column(name = "year")
    private int year;


    @OneToMany(mappedBy = "model")      //CHECK
    private List<Trim> trims;

    @ManyToMany
    @JoinTable(
            name = "model_feature",
            joinColumns = @JoinColumn(name = "model_ID"),
            inverseJoinColumns = @JoinColumn(name = "feature_ID")
    )
    private Set<Feature> features;

    public Model() {
    }

    public Model(String name, int year) {
        this.name = name;
        this.year = year;
        features = new HashSet<Feature>();
        trims = new ArrayList<Trim>();

    }

    public int getModel_ID() {
        return model_ID;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Trim> getTrims() {
        return trims;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTrims(List<Trim> trims) {
        this.trims = trims;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}

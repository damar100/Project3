package model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Trims")
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"model", "name"}))
public class Trim {




    @Id
   // @Column(name = "trim_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trim_ID;

    @Column(length = 35)
    private String name;

  //  @Column(name = "cost")
    private float cost;


    @OneToMany(mappedBy = "trim")       //CHECK
    private Set<AvailablePackage> availablePackages;

    @ManyToOne
    @JoinColumn(name = "model_ID")      //CHECK
    private Model model;

    @ManyToMany             //check
    @JoinTable(
            name = "trim_feature",
            joinColumns = @JoinColumn(name = "trim_ID"),
            inverseJoinColumns = @JoinColumn(name = "feature_ID")
    )
    private Set<Feature> features;//= new HashSet<>();

    public Trim() {
    }

    public Trim(String name, float cost, Model model) {

        this.name = name;
        this.cost = cost;
        this.model = model;
        features = new HashSet<Feature>();
        availablePackages = new HashSet<AvailablePackage>();

    }


    public int getTrim() {
        return trim_ID;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }

    public Set<AvailablePackage> getAvailablePackages() {
        return availablePackages;
    }

    public Model getModel() {
        return model;
    }

    public Set<Feature> getFeatures() { //maybe change back to return features;
        return model.getFeatures(); // model.getFeatures();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setAvailablePackages(Set<AvailablePackage> availablePackages) {
        this.availablePackages = availablePackages;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}

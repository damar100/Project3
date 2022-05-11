package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Packages")
public class Package {

    @Id
  //  @Column(name = "package_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int package_ID;

    @Column(length = 35,nullable = false)
    private String name;


//    @OneToMany(mappedBy = "package_ID")
//    private Set<Trim> package_;

    @OneToMany(mappedBy = "package_ID")     //CHECK
    private Set<AvailablePackage> availablePackages;

    @ManyToMany
    @JoinTable(
            name = "package_feature",
            joinColumns = @JoinColumn(name = "package_ID"),
            inverseJoinColumns = @JoinColumn(name = "feature_ID")
    )
    private Set<Feature> features;

    public Package() {
    }

    public Package(String name) {
        this.name = name;
        features = new HashSet<Feature>();
        availablePackages = new HashSet<AvailablePackage>();
    }


    public int getPackage_ID() {
        return package_ID;
    }

    public String getName() {
        return name;
    }

    public Set<AvailablePackage> getAvailablePackages() {
        return availablePackages;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailablePackages(Set<AvailablePackage> availablePackages) {
        this.availablePackages = availablePackages;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}

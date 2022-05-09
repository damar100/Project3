package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Packages")
public class Package {

    @Id
  //  @Column(name = "package_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int package_ID;

    @Column(length = 35)
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
}

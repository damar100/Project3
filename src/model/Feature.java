package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feature_ID;

    @Column(length = 35)
    private String name;

    @OneToMany(mappedBy = "feature")
    private Set<Package_Feature> package_feature;

    @OneToMany(mappedBy = "feature")
    private Set<Trim_Feature> feature_trim;

}

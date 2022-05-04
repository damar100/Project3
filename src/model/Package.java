package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int package_ID;

    @Column(length = 35)
    private String name;

    @OneToMany(mappedBy = "package_")
    private Set<Package_Feature> package_feature;


}

package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "AvailablePackages")
public class AvailablePackage {

    @Id
   // @Column(name = "availablePackage_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availablePackage_ID;

  //  @Column(name = "cost")
    private float cost;

    @Id
    @JoinColumn(name = "package_ID")
    @ManyToOne
    private Package package_ID;

    @Id
    @JoinColumn(name = "trim_ID")
    @ManyToOne
    private Trim trim;

//    @ManyToMany
//    @JoinTable(
//            name = "AutomobilePackages",
//            joinColumns = @JoinColumn(name = "automobile_ID"),
//            inverseJoinColumns = @JoinColumn(name = "availablePackage_ID")
//    )
//    private Set<Automobile> packages;

}

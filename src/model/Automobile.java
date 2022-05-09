package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "Automobiles")
public class Automobile {
    //package -> feature
    //parent  -> child

    @Id
   // @Column(name = "automobile_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int automobile_ID;



    @Column(length = 25,unique=true)
    private String vin;

    @Column(length = 15)
    private String color;

    @ManyToOne
    @JoinColumn(name = "trim_ID")       //CHECK
    private Trim trim;

//    @ManyToMany(mappedBy = "packages")
//    private Set<AvailablePackage> automobilepackages;

}

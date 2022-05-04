package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Trims")
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trim_ID;

    @Column(length = 35)
    private String name;

    private float cost;

    @OneToMany(mappedBy = "trim")
    private Set<Trim_Feature> trim_feature;

    @OneToMany(mappedBy = "trim")
    private Set<Automobile_Trim> automobile_trim;

}

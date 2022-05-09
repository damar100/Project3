package model;

import jakarta.persistence.*;

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

    @ManyToMany     //check
    @JoinTable(
            name = "model_feature",
            joinColumns = @JoinColumn(name = "model_ID"),
            inverseJoinColumns = @JoinColumn(name = "feature_ID")
    )
    private Set<Feature> features;
}

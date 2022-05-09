package model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "Trims")
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"model", "name"}))
public class Trim {




    @Id
   // @Column(name = "trim_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trim;

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
    private Set<Feature> features;
}

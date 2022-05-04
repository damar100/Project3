package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int model_ID;

    @Column(length = 35)
    private String name;

    private int year;

    @OneToMany(mappedBy = "model")
    private Set<Model_Feature> model_feature;

}

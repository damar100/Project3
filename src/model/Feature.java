package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Features")
public class Feature {

    @Id
  //  @Column(name = "feature_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feature_ID;

    @Column(length = 35,unique=true)
    private String name;


}

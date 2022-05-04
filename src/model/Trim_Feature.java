package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Trim_Features")
public class Trim_Feature {

    @Id
    @JoinColumn(name = "trim_ID")
    @ManyToOne
    private Trim trim;

    @Id
    @JoinColumn(name = "Feature_ID")
    @ManyToOne
    private Feature feature;


}

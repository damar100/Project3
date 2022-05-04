package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Package_Features")
public class Package_Feature {

    @Id
    @JoinColumn(name = "Package_ID")
    @ManyToOne
    private Package package_;

    @Id
    @JoinColumn(name = "Feature_ID")
    @ManyToOne
    private Feature feature;
}

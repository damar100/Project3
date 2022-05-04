package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Model_Packages")
public class Model_Feature {

    @Id
    @JoinColumn(name = "Model_ID")
    @ManyToOne
    private Model model;

    @Id
    @JoinColumn(name = "Feature_ID")
    @ManyToOne
    private Feature feature;
}

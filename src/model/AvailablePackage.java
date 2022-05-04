package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "AvailablePackages")
public class AvailablePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availablePackage_ID;

    private float cost;

}

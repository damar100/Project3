package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "AvailablePackages")
public class AvailablePackage {


    @Id
   // @Column(name = "availablePackage_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availablePackage_ID;

  //  @Column(name = "cost")
    private float cost;

   // @Id
    @JoinColumn(name = "package_ID")
    @ManyToOne
    private Package package_ID;

   // @Id
    @JoinColumn(name = "trim_ID")
    @ManyToOne
    private Trim trim;

    @ManyToMany(mappedBy = "chosenpackages")
    private Set<Automobile> auto_chosenpackages;
    public AvailablePackage() {
    }

    public AvailablePackage(Package package_ID,float cost, Trim trim) {
        this.cost = cost;
        this.package_ID = package_ID;
        this.trim = trim;
        auto_chosenpackages = new HashSet<Automobile>();
    }

    public int getAvailablePackage_ID() {
        return availablePackage_ID;
    }

    public float getCost() {
        return cost;
    }

    public Package getPackage_ID() {
        return package_ID;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setPackage_ID(Package package_ID) {
        this.package_ID = package_ID;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }
}

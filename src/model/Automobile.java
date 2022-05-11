package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Automobiles")
public class Automobile {
    //package -> feature
    //parent  -> child

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int automobile_ID;

    @Column(length = 25,unique=true)
    private String vin;

//    @Column(length = 15)
//    private String color;


    @ManyToOne
    @JoinColumn(name = "trim_ID")       //CHECK
    private Trim trim;

    @ManyToMany
    @JoinTable(
            name = "chosenpackages",
            joinColumns = @JoinColumn(name="automobile_ID"),
            inverseJoinColumns = @JoinColumn(name="availablePackage_ID")
    )
    private Set<AvailablePackage> chosenpackages;

    public Automobile() {

    }

    public Automobile(String vin, Trim trim) {
        this.vin = vin;
        this.trim = trim;
        chosenpackages = new HashSet<AvailablePackage>();
    }

    public int getAutomobile_ID() {
        return automobile_ID;
    }

    public String getVin() {
        return vin;
    }


    public Trim getTrim() {
        return trim;
    }

    public Set<AvailablePackage> getAvailablePackages() {
        return chosenpackages;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public void setAvailablePackages(Set<AvailablePackage> availablePackages) {
        this.chosenpackages = availablePackages;
    }

    public Set<Feature> getFeatures(){
        Set<Feature> features = new HashSet<Feature>();
        for (AvailablePackage ap : chosenpackages){
            features.addAll(ap.getPackage_ID().getFeatures());
        }
        features.addAll(trim.getModel().getFeatures()); // maybe need to change to trim.getFeatures()
        return features;
    }

    public double stickerPrice()
    {

        float sum = 0;
        float sum2 = getTrim().getCost();
        for (AvailablePackage ap : chosenpackages){
            sum = ap.getCost() + sum;
        }
        return sum + sum2;
    }

}

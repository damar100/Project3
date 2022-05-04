package model;

import jakarta.persistence.*;

@Entity(name = "Automobiles")
public class Automobile {
    //package -> feature
    //parent  -> child

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int automobile_ID;

    @Column(length = 25)
    private String vin;

    @Column(length = 15)
    private String color;

}

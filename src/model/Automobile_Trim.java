package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Automobile_Trims")
public class Automobile_Trim {


    @Id
    @JoinColumn(name = "automobile_ID")
    @ManyToOne
    private Automobile automobile;

    @Id
    @JoinColumn(name = "trim_ID")
    @ManyToOne
    private Trim trim;
}

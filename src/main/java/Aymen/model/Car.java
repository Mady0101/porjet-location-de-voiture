package Aymen.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity(name = "car")
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Car {
    @Id
    private String immatriculation;


    @Column( nullable = false , name = "marque")
    private String marque;

    @Column( nullable = false , name = "circulation_start")
    private String circulationStart;

    @Column( nullable = false , name = "prix")
    private double prix;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "car")
    private Set<Location> locations;

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public String getCirculationStart() {
        return circulationStart;
    }

    public double getPrix() {
        return prix;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setCirculationStart(String circulationStart) {
        this.circulationStart = circulationStart;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
}

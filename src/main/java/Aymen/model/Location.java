package Aymen.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "location")
@Table(name = "location")

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false , name = "date_deb")
    private String date_deb;

    @Column(nullable = false , name = "date_fin")
    private String date_fin;

    @Column(nullable = false , name = "garantie")
    private String garantie;

    @Column(nullable = false , name = "frais")
    private double frais;

    @Column(nullable = false , name = "montant_garantie")
    private double montant_garantie;

    @Column(nullable = false , name = "transaction_method")
    private TransactionType transaction;

    @ManyToOne
    @JoinColumn(name="car_id", nullable=false )
    private Car car;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false )
    private AppUser user;

    public Integer getId() {
        return id;
    }

    public String getDate_deb() {
        return date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public String getGarantie() {
        return garantie;
    }

    public double getFrais() {
        return frais;
    }

    public double getMontant_garantie() {
        return montant_garantie;
    }

    public TransactionType getTransaction() {
        return transaction;
    }

    public Car getCar() {
        return car;
    }

    public AppUser getUser() {
        return user;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    public void setMontant_garantie(double montant_garantie) {
        this.montant_garantie = montant_garantie;
    }

    public void setTransaction(TransactionType transaction) {
        this.transaction = transaction;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}

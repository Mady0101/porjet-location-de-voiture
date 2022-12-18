package Aymen.dto;

import Aymen.model.AppUser;
import Aymen.model.Car;
import Aymen.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

@Data
@AllArgsConstructor
public class LocationRequestDTO {
    private String date_deb;
    private String date_fin;
    private String garantie;
    private double frais;
    private double montant_garantie;
    private TransactionType transaction;
    private String carMatricule;
    private Integer userId;
}

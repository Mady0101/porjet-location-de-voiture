package Aymen.dto;

import Aymen.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseDTO {
    private String date_deb;
    private String date_fin;
    private String garantie;
    private double frais;
    private double montant_garantie;
    private TransactionType transaction;
    private UserResponseDTO user ;
    private CarResponseDTO car;
}

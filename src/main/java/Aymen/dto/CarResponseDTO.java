package Aymen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class CarResponseDTO {

    private String immatriculation;



    private String marque;


    private String circulationStart;


    private double prix;
}

package Aymen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CarRequestDTO {
    private String immatriculation;



    private String marque;


    private String circulationStart;


    private double prix;
}

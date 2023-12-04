package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data @AllArgsConstructor
@NoArgsConstructor
public class Adresse implements Serializable {
    private String pays;
    private String ville;
    private String rue;
    private String numero;
    private String lieuDit;
    private String positionGPS;

}

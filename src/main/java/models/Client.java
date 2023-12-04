package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    private String nom;
    private String prenom;
    private String numeroCarte;
    private int cvv;
    private String dateExpiration;

}

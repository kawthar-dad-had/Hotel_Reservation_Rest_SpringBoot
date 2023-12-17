package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateArrivee;
    private Date dateDepart;
    private int nombrePersonnes;
    @Embedded
    private Client client;


    @ManyToOne
    @JoinColumn(name="idHotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name="idChambre")
    private Chambre chambre;


    @ManyToOne
    @JoinColumn(name="idAgence")
    private AgencePartenaire agence;
    private double prix;

    public Reservation(Date dateArrivee, Date dateDepart, int nombrePersonnes, Client client, Long idHotel, Long idChambre, Long agencePartenaireId) {
    }
}

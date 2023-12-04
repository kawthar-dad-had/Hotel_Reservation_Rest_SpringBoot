package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String typeChambre;
    private int nombreLits;
    private double prix;


    @ManyToOne
    @JoinColumn(name="idHotel")
    private Hotel hotel;
    private String imageUrl;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Reservation> lesReservations;






}

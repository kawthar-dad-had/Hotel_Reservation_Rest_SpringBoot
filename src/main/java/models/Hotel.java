package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Set;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    @Embedded
    private Adresse adresse;
    private int nombreEtoiles;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "AgenceHotel",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "Agence_id"))
    Set<AgencePartenaire> tarifsAgences;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Reservation> lesReservations;



    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Chambre> lesChambres;


}

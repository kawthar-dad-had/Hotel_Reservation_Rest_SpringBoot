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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencePartenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String motDePasse;
    private double tarif;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "AgenceHotel",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "Agence_id"))
    private Set<Hotel> hotels;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Reservation> lesReservations;


}

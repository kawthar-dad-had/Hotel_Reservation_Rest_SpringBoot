package controllers;

import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repositories.AgencePartenaireRepository;
import repositories.ChambreRepository;
import repositories.HotelRepository;
import repositories.ReservationRepository;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("reservationservice/api")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private AgencePartenaireRepository agencePartenaireRepository;
    private Logger logger = LoggerFactory.getLogger(DisponibiliteController.class);
    @PostMapping("/reservation")

    public ResponseEntity<?> reservation(@RequestParam("agenceNom") String agenceNom , @RequestParam("password") String password  ,@RequestParam("dateArrivee") Date dateArrivee , @RequestParam("dateDepart") Date dateDepart , @RequestParam("nombrePersonnes") int nombrePersonnes , @RequestParam("idHotel") Long idHotel , @RequestParam("idChambre") Long idChambre  , @RequestParam("nom") String nom , @RequestParam("prenom") String prenom ,@RequestParam("numeroCarte") String numeroCarte , @RequestParam("cvv") int cvv , @RequestParam("dateExpiration") String dateExpiration ){

        AgencePartenaire agencePartenaire = agencePartenaireRepository.findByNomAndMotDePasse(agenceNom,password);

        if(agencePartenaire == null)
        {
            return ResponseEntity.notFound().build();
        }

        Long agencePartenaireId = agencePartenaire.getId();

        Client client = new Client(nom,prenom,numeroCarte,cvv,dateExpiration );
        Optional<Hotel> optionalHotel = hotelRepository.findById(idHotel);
        Hotel hotel = optionalHotel.orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));
        Optional<Chambre> optionalChambre = chambreRepository.findById(idChambre);
        Chambre chambre = optionalChambre.orElseThrow(() -> new IllegalArgumentException("Invalid chambre ID"));

        Reservation reservation = new

        return "kawthar";




    }
}

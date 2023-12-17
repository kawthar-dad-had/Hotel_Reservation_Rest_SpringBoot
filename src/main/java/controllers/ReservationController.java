package controllers;

import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.AgencePartenaireRepository;
import repositories.ChambreRepository;
import repositories.HotelRepository;
import repositories.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Logger logger = LoggerFactory.getLogger(ReservationController.class);
    @CrossOrigin(origins = "http://localhost:3000" )
    @PostMapping("/reservation")

        public ResponseEntity<?> reservation(@RequestParam("agenceNom") String agenceNom , @RequestParam("password") String password  ,@RequestParam("dateArrivee") String dateArrivee , @RequestParam("dateDepart") String dateDepart , @RequestParam("nombrePersonnes") int nombrePersonnes , @RequestParam("idHotel") Long idHotel , @RequestParam("idChambre") Long idChambre  , @RequestParam("nom") String nom , @RequestParam("prenom") String prenom ,@RequestParam("numeroCarte") String numeroCarte , @RequestParam("cvv") int cvv , @RequestParam("dateExpiration") String dateExpiration ) throws ParseException {

        AgencePartenaire agencePartenaire = agencePartenaireRepository.findByNomAndMotDePasse(agenceNom,password);
        System.out.println(agencePartenaire);
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

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateArrivee1 = dateFormat.parse(dateArrivee);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDepart1 = dateFormat1.parse(dateDepart);

        Reservation reservation = new Reservation();
        reservation.setDateArrivee(dateArrivee1);
        reservation.setDateDepart(dateDepart1);
        reservation.setNombrePersonnes(nombrePersonnes);
        reservation.setClient(client);
        reservation.setHotel(hotel);
        reservation.setChambre(chambre);
        reservation.setAgence(agencePartenaire);

        reservationRepository.save(reservation);
        return ResponseEntity.ok(reservation);

    }
}
package controllers;

import models.AgencePartenaire;
import models.Chambre;
import models.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.AgencePartenaireRepository;
import repositories.HotelRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("comparateurservice/api")
public class ComparateurController {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private AgencePartenaireRepository agencePartenaireRepository;
    private Logger logger = LoggerFactory.getLogger(ComparateurController.class);

    @CrossOrigin(origins = "http://localhost:3000" )
    @GetMapping("/comparateur")
    public ResponseEntity<?> getOffres(@RequestParam("dateArrivee") String dateArrivee , @RequestParam("dateDepart") String dateDepart , @RequestParam("nombrePersonnes") int nombrePersonnes  ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateArrivee1 = dateFormat.parse(dateArrivee);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDepart1 = dateFormat1.parse(dateDepart);
        List<Chambre> hotels = hotelRepository.findAvailablehotel( nombrePersonnes , dateArrivee1 , dateDepart1);
        //List<Hotel> hotels = hotelRepository.findAll();
        return ResponseEntity.ok(hotels);
    }


}

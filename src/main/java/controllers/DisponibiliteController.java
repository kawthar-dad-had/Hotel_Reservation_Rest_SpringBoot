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
import repositories.ChambreRepository;
import repositories.HotelRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("disponibiliteservice/api")
public class DisponibiliteController {
    @Autowired
    private AgencePartenaireRepository agencePartenaireRepository;
    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private HotelRepository hotelRepository;
    private Logger logger = LoggerFactory.getLogger(DisponibiliteController.class);

    //@ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://localhost:3000" )
    @GetMapping("/disponibilite")
    public ResponseEntity<?> getOffres(@RequestParam("nom") String nom , @RequestParam("password") String password , @RequestParam("nombreLits") int nombreLits , @RequestParam("startDate") String startDate , @RequestParam("endDate") String endDate) throws ParseException {
        //boolean isAuth = agencePartenaireRepository.existsByNomAndMotDePasse(nom,password);
        AgencePartenaire agencePartenaire = agencePartenaireRepository.findByNomAndMotDePasse(nom,password);

        if(agencePartenaire == null)
        {
            return ResponseEntity.notFound().build();
        }

        Long agencePartenaireId = agencePartenaire.getId();
        System.out.println(agencePartenaireId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = dateFormat.parse(startDate);
        System.out.println(startDate1);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate1 = dateFormat1.parse(endDate);

        //List<Hotel> chambres = hotelRepository.findAvailableChambres(agencePartenaireId , nombreLits , startDate1 , endDate1);
        //List<AgencePartenaire> chambres = agencePartenaireRepository.findAll();
        List<Chambre> chambres = chambreRepository.findAvailableChambres(agencePartenaireId , nombreLits , startDate1 , endDate1);
        return ResponseEntity.ok(chambres);
    };



}

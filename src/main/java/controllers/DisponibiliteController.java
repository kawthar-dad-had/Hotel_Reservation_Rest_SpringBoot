package controllers;

import models.AgencePartenaire;
import models.Chambre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.AgencePartenaireRepository;
import repositories.ChambreRepository;

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
    private Logger logger = LoggerFactory.getLogger(DisponibiliteController.class);

    //@ResponseStatus(HttpStatus.CREATED)
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
        Date startDate1 = dateFormat.parse("2025-07-24");

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate1 = dateFormat1.parse("2025-07-27");

        List<Chambre> chambres = chambreRepository.findAvailableChambres(agencePartenaireId , nombreLits , startDate1 , endDate1);
        //List<Chambre> chambres = chambreRepository.findAll();
        return ResponseEntity.ok(chambres);
    };



}

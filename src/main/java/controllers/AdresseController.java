package controllers;

import models.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdresseController {
    @Autowired
    //private AdresseRepository repository;
    private static final String uri = "adresseservice/api";
    //@ResponseStatus(HttpStatus.CREATED)
    //@GetMapping(uri+"/adresses")
    //public List<Adresse> getAllAdresse() {return repository.findAll()}

    //PathVariable
    //PostMapping

}

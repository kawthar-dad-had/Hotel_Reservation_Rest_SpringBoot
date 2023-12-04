package data;

import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.AgencePartenaireRepository;
import repositories.ChambreRepository;
import repositories.HotelRepository;
import repositories.ReservationRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Configuration
public class CreationData {
    private Logger logger = LoggerFactory.getLogger(CreationData.class);
    @Bean
    public CommandLineRunner initDatabaseReservation(ReservationRepository reservationRepository, HotelRepository hotelRepository, ChambreRepository chambreRepository, AgencePartenaireRepository agencePartenaireRepository){

        return args -> {
            logger.info("Preloading database with " + hotelRepository.save(
                    new Hotel(0, "AZ", new Adresse("France", "Montpellier", "rue 1", "58", "lieu 1", "gps pos"), 4, new HashSet<>(), new HashSet<>(), new HashSet<>())
            ));

            Hotel hotel = hotelRepository.findById(1L).get();
            List<Hotel> hotels = hotelRepository.findAll();

            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0, "Unique",1,200.0,hotel, "image.jpg", new HashSet<>())
            ));

            logger.info("Preloading database with " + agencePartenaireRepository.save(
                    new AgencePartenaire(0, "Agence 1", "motdepasse1", 0.9, new HashSet<>(hotels), new HashSet<>())
            ));

            Chambre chambre = chambreRepository.findById(1L).get();
            AgencePartenaire agence = agencePartenaireRepository.findById(1L).get();
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, new Date(24-07-2023), new Date(20-07-2023), 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel, chambre, agence, 200.0)
            ));
        };
    };
}

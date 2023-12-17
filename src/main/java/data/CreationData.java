package data;

import models.*;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.AgencePartenaireRepository;
import repositories.ChambreRepository;
import repositories.HotelRepository;
import repositories.ReservationRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Configuration
public class CreationData {
    private Logger logger = LoggerFactory.getLogger(CreationData.class);
    @Bean
    public CommandLineRunner initDatabaseReservation(ReservationRepository reservationRepository, HotelRepository hotelRepository, ChambreRepository chambreRepository, AgencePartenaireRepository agencePartenaireRepository){

        return args -> {
            AgencePartenaire agence1 = new AgencePartenaire(0, "Agence 1", "motdepasse1", 0.9, new HashSet<>(), new HashSet<>());
            AgencePartenaire agence2 = new AgencePartenaire(0, "Agence 2", "motdepasse2", 0.9, new HashSet<>(), new HashSet<>());
            //Hibernate.initialize(agence1.getHotels());
            //Hibernate.initialize(agence2.getHotels());
            //agence1.getHotels().add(hotel1);
            logger.info("Preloading database with " + agencePartenaireRepository.save(agence1));
            //agence2.getHotels().add(hotel2);
            logger.info("Preloading database with " + agencePartenaireRepository.save(agence2));
            AgencePartenaire agence11 = agencePartenaireRepository.findById(1L).get();
            AgencePartenaire agence22 = agencePartenaireRepository.findById(2L).get();

            Hotel hotel11 = new Hotel(0, "AZ", new Adresse("France", "Montpellier", "rue 1", "58", "lieu 1", "gps pos"), 4, new HashSet<>(), new HashSet<>(), new HashSet<>());
            Hotel hotel22 = new Hotel(0, "AZHotel", new Adresse("Algerie", "Oran", "rue 1", "58", "lieu 1", "gps pos"), 4, new HashSet<>(), new HashSet<>(), new HashSet<>());
// Création de six hôtels avec des noms existants

// Hôtel 1
            Hotel hotel111 = new Hotel(0, "Hôtel Plaza Athénée", new Adresse("France", "Paris", "25 Avenue Montaigne", "75008", "Paris", "48.86835, 2.30341"), 5, new HashSet<>(), new HashSet<>(), new HashSet<>());

// Hôtel 2
            Hotel hotel222 = new Hotel(0, "Hotel Ritz Paris", new Adresse("France", "Paris", "15 Place Vendôme", "75001", "Paris", "48.86794, 2.32922"), 5, new HashSet<>(), new HashSet<>(), new HashSet<>());

// Hôtel 3
            Hotel hotel33 = new Hotel(0, "The Savoy London", new Adresse("United Kingdom", "London", "Strand", "WC2R 0EZ", "London", "51.51071, -0.12007"), 5, new HashSet<>(), new HashSet<>(), new HashSet<>());

// Hôtel 4
            Hotel hotel44 = new Hotel(0, "The Peninsula Hong Kong", new Adresse("Hong Kong", "Salisbury Rd, Tsim Sha Tsui", "", "", "Hong Kong", "22.29545, 114.17212"), 5, new HashSet<>(), new HashSet<>(), new HashSet<>());

// Hôtel 5
            Hotel hotel55 = new Hotel(0, "Four Seasons Hotel George V", new Adresse("France", "Paris", "31 Avenue George V", "75008", "Paris", "48.86926, 2.30058"), 5, new HashSet<>(), new HashSet<>(), new HashSet<>());

// Hôtel 6
            Hotel hotel66 = new Hotel(0, "The Ritz-Carlton New York, Central Park", new Adresse("United States", "New York", "Central Park South", "10019", "New York", "40.76577, -73.97642"), 5, new HashSet<>(), new HashSet<>(), new HashSet<>());


            hotel11.getTarifsAgences().add(agence11);
            hotel22.getTarifsAgences().add(agence22);
// Relier hotel1 avec agence11
            hotel111.getTarifsAgences().add(agence11);

// Relier hotel2 avec agence22
            hotel222.getTarifsAgences().add(agence22);
            hotel33.getTarifsAgences().add(agence11);
            hotel44.getTarifsAgences().add(agence22);
            hotel55.getTarifsAgences().add(agence11);
            hotel66.getTarifsAgences().add(agence22);

            logger.info("Preloading database with " + hotelRepository.save(hotel11));
            logger.info("Preloading database with " + hotelRepository.save(hotel22));
            logger.info("Preloading database with " + hotelRepository.save(hotel111));
            logger.info("Preloading database with " + hotelRepository.save(hotel222));
            logger.info("Preloading database with " + hotelRepository.save(hotel33));
            logger.info("Preloading database with " + hotelRepository.save(hotel44));
            logger.info("Preloading database with " + hotelRepository.save(hotel55));
            logger.info("Preloading database with " + hotelRepository.save(hotel66));



            Hotel hotel1 = hotelRepository.findById(1L).get();
            Hotel hotel2 = hotelRepository.findById(2L).get();
            Hotel hotel3 = hotelRepository.findById(3L).get();
            Hotel hotel4 = hotelRepository.findById(4L).get();
            Hotel hotel5 = hotelRepository.findById(5L).get();
            Hotel hotel6 = hotelRepository.findById(6L).get();
            Hotel hotel7 = hotelRepository.findById(7L).get();
            Hotel hotel8 = hotelRepository.findById(8L).get();
            List<Hotel> hotels = hotelRepository.findAll();
            for (Hotel hotel : hotels) {
                // Faites quelque chose avec chaque hôtel, par exemple :
                System.out.println("ID : " + hotel.getId() + ", Nom : " + hotel.getNom());
            }

            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0, 1,"Unique",280.0,hotel1, "https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8", new HashSet<>())
            ));
            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0,1,"Unique",290.0,hotel2, "https://static5.depositphotos.com/1001540/504/i/950/depositphotos_5045505-stock-photo-luxurious-hotel.jpg", new HashSet<>())
            ));
            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0, 1,"Unique",300,hotel3, "https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8", new HashSet<>())
            ));
            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0,1,"Unique",310.0,hotel4, "https://static5.depositphotos.com/1001540/504/i/950/depositphotos_5045505-stock-photo-luxurious-hotel.jpg", new HashSet<>())
            ));
            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0, 1,"Unique",320.0,hotel5, "https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8", new HashSet<>())
            ));
            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0,1,"Unique",330.0,hotel6, "https://static5.depositphotos.com/1001540/504/i/950/depositphotos_5045505-stock-photo-luxurious-hotel.jpg", new HashSet<>())
            ));
            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0, 2,"Double",340.0,hotel7, "https://www.deco.fr/sites/default/files/styles/article_970x500/public/migration-images/101525.webp?itok=-9s_4iV8", new HashSet<>())
            ));
            logger.info("Preloading database with " + chambreRepository.save(
                    new Chambre(0,1,"Unique",350.0,hotel8, "https://static5.depositphotos.com/1001540/504/i/950/depositphotos_5045505-stock-photo-luxurious-hotel.jpg", new HashSet<>())
            ));
            List<Chambre> chambres = chambreRepository.findAll();
            for (Chambre chambre : chambres) {
                // Faites quelque chose avec chaque hôtel, par exemple :
                System.out.println("ID : " + chambre.getId() );
            }

            List<AgencePartenaire> agences = agencePartenaireRepository.findAll();
            for (AgencePartenaire agence : agences) {
                // Faites quelque chose avec chaque hôtel, par exemple :
                System.out.println("ID : " + agence.getId() );
                //for (Hotel hotel : agence.getHotels()) {
                  //  System.out.println("Nom de l'hôtel : " + hotel.getNom() );
                //}
            }

            Chambre chambre1 = chambreRepository.findById(1L).get();
            Chambre chambre2 = chambreRepository.findById(2L).get();
            Chambre chambre3 = chambreRepository.findById(3L).get();
            Chambre chambre4 = chambreRepository.findById(4L).get();
            Chambre chambre5 = chambreRepository.findById(5L).get();
            Chambre chambre6 = chambreRepository.findById(6L).get();
            Chambre chambre7 = chambreRepository.findById(7L).get();
            Chambre chambre8 = chambreRepository.findById(8L).get();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateArrivee1 = dateFormat.parse("2025-07-19");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDepart1 = dateFormat1.parse("2025-07-28");

            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            Date dateArrivee11 = dateFormat2.parse("2025-07-24");
            SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDepart11 = dateFormat3.parse("2025-07-28");

            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee1, dateDepart1, 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel1, chambre1, agence1, 280.0)
            ));
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee11, dateDepart11, 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel2, chambre2, agence2, 290.0)
            ));
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee11, dateDepart11, 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel3, chambre3, agence1, 300.0)
            ));
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee11, dateDepart11, 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel4, chambre4, agence2, 310.0)
            ));
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee11, dateDepart11, 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel5, chambre5, agence1, 320.0)
            ));
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee11, dateDepart11, 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel6, chambre6, agence2, 330.0)
            ));
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee11, dateDepart11, 2, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel7, chambre7, agence1, 340.0)
            ));
            logger.info("Preloading database with " + reservationRepository.save(
                    new Reservation(0, dateArrivee11, dateDepart11, 1, new Client("Dadoua Hadria", "Kawthar", "45486486654", 455, "02/25"), hotel8, chambre8, agence2, 350.0)
            ));
        };
    };
}

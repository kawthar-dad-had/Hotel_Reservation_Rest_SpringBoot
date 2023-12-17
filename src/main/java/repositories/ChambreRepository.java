package repositories;

import models.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface ChambreRepository extends JpaRepository<Chambre,Long> {

    @Query(value = "SELECT DISTINCT c.id as distinct_id, c.*" +
                    "FROM Chambre c " +
                    "JOIN Hotel h ON c.id_hotel = h.id " +
                    "JOIN Agence_hotel hap ON c.id_hotel = hap.hotel_id " +
                    "JOIN Reservation r ON r.id_chambre = c.id " +
                    "WHERE hap.agence_id = :agencePartenaireId " +
                    "AND c.nombre_lits = :nombreLits " +
                    "AND c.id NOT IN (" +
                    "    SELECT r.id_chambre " +
                    "    FROM Reservation r " +
                    "    WHERE (:startDate BETWEEN r.date_arrivee AND r.date_depart) " +
                    "       OR (:endDate BETWEEN r.date_arrivee AND r.date_depart)" +
                    ")", nativeQuery = true)
    List<Chambre> findAvailableChambres(
            @Param("agencePartenaireId") Long agencePartenaireId,
            @Param("nombreLits") int nombreLits,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);
            //@Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
            //@Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate);

}

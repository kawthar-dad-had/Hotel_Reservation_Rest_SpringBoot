package repositories;

import models.Adresse;
import models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HotelRepository extends JpaRepository<Hotel,Long> {
}

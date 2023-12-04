package repositories;

import models.AgencePartenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgencePartenaireRepository extends JpaRepository<AgencePartenaire,Long> {
    boolean existsByNomAndMotDePasse(String nom , String motDePasse);

    AgencePartenaire findByNomAndMotDePasse(String nom, String password);
}

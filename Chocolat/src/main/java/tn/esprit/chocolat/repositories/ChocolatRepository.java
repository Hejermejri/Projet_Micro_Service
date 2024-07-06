package tn.esprit.chocolat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.chocolat.entities.Chocolat;
@Repository
public interface ChocolatRepository extends JpaRepository<Chocolat,Long> {
}

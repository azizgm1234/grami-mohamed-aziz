package tn.esprit.se.projet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.se.projet1.entites.Chambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {





    Chambre findByNumeroChambre(Long numero);
}

package tn.esprit.se.projet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.se.projet1.entites.Etudiant;
//PagingAndSortingRepository
//JpaRepository
//CrudRepository
public interface EtudiantRepository extends JpaRepository <Etudiant,Long>{
    Etudiant findByNomEtAndPrenomEt(String nomEt, String prenomEt);
}

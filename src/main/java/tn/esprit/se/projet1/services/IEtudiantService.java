package tn.esprit.se.projet1.services;

import tn.esprit.se.projet1.entites.Etudiant;
import tn.esprit.se.projet1.entites.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);

    Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation);
}

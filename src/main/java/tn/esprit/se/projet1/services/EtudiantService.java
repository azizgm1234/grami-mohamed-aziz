package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Etudiant;
import tn.esprit.se.projet1.entites.Reservation;
import tn.esprit.se.projet1.repository.EtudiantRepository;
import tn.esprit.se.projet1.repository.ReservationRepository;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {etudiantRepository.deleteById(idEtudiant);
    }
    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Reservation reservation = reservationRepository.findById(idReservation).get();
        Etudiant etudiant = etudiantRepository.findByNomEtAndPrenomEt( nomEt, prenomEt);
        Set<Reservation> Reservationmiseajour = new HashSet<>();
        if (etudiant.getReservations()!=null){
            Reservationmiseajour=etudiant.getReservations();
        }
        Reservationmiseajour.add(reservation);
        etudiant.setReservations(Reservationmiseajour);
        etudiantRepository.save(etudiant);
        return etudiant;



    }

}

package tn.esprit.se.projet1.services;



import tn.esprit.se.projet1.entites.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();

    Reservation addReservation(Reservation r);

    Reservation updateReservation(Reservation r);

    Reservation retrieveReservation(String idReservation);

    void removeReservation(String idReservation);
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut , Date dateFin );
}

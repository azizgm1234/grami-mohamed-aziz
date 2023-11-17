package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Reservation;
import tn.esprit.se.projet1.repository.ReservationRepository;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ReservationService implements IReservationService{
    ReservationRepository reservationRepository;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public void removeReservation(String idReservation) {
    reservationRepository.deleteById(idReservation);
    }
}

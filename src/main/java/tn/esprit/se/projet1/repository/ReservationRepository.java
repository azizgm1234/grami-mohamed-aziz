package tn.esprit.se.projet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.se.projet1.entites.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}

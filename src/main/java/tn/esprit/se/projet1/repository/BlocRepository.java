package tn.esprit.se.projet1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.se.projet1.entites.Bloc;
import tn.esprit.se.projet1.entites.Universite;

import java.util.List;

public interface BlocRepository  extends JpaRepository<Bloc,Long> {

    Bloc findBynomBloc(String nomBloc);
}

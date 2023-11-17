package tn.esprit.se.projet1.services;



import tn.esprit.se.projet1.entites.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();

    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    Bloc retrieveBloc(Long idBloc);

    void removeBloc(Long idBloc);
}

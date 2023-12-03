package tn.esprit.se.projet1.services;



import tn.esprit.se.projet1.entites.Bloc;
import tn.esprit.se.projet1.entites.Chambre;
import tn.esprit.se.projet1.entites.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(Long idChambre);

    void removeChambre(Long idChambre);

    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);

    Bloc desaffecterChambreDeBloc(List<Long> numChambre);

    List<Chambre> getChambresParNomBloc(String nomBloc);


    List<Long> getChambresParNomBloc2(String nomBloc);

    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);
}

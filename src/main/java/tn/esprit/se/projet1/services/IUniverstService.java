package tn.esprit.se.projet1.services;

import tn.esprit.se.projet1.entites.Universite;


import java.util.List;

public interface IUniverstService {
    List<Universite> retrieveAllUniversits();

    Universite addUniversit(Universite u);

    Universite updateUniversit(Universite u);

    Universite retrieveUniversit(Long idUniversit);

    Universite removeUniversit(Long idUniversit);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniveriste);

    Universite desaffecterFoyerAUniversite(long idUniversite);
}

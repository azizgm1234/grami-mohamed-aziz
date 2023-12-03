package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Foyer;
import tn.esprit.se.projet1.entites.Universite;
import tn.esprit.se.projet1.repository.FoyerRepository;
import tn.esprit.se.projet1.repository.UniversiteRepository;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UniversitService implements IUniverstService{

    FoyerRepository foyerRepository;
    UniversiteRepository universitRepository;
    @Override
    public List<Universite> retrieveAllUniversits() {
        return universitRepository.findAll();
    }

    @Override
    public Universite addUniversit(Universite u) {
        return universitRepository.save(u);
    }

    @Override
    public Universite updateUniversit(Universite u) {
        return universitRepository.save(u);
    }

    @Override
    public Universite retrieveUniversit(Long idUniversit) {
        return universitRepository.findById(idUniversit).get();
    }

    @Override
    public Universite removeUniversit(Long idUniversit) {
    universitRepository.deleteById(idUniversit);
        return null;
    }
    @Override

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer=foyerRepository.findById( idFoyer).get();
        Universite universite=universitRepository.findByNomUniversite(nomUniversite);
        universite.setFoyer(foyer);
        universitRepository.save(universite);
        return universite;

    }
    @Override
    public Universite desaffecterFoyerAUniversite (long idUniversite) {
        Universite universite=universitRepository.findById(idUniversite).get();
        universite.setFoyer(null);
        universitRepository.save(universite);
        return universite;

    }

}

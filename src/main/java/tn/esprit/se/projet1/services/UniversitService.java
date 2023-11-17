package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Universite;
import tn.esprit.se.projet1.repository.UniversiteRepository;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UniversitService implements IUniverstService{
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
}

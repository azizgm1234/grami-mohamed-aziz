package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Foyer;
import tn.esprit.se.projet1.repository.FoyerRepository;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FoyerService implements IFoyerService{
    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {

        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {

             foyerRepository.save(f);
        return f;
    }

    @Override
    public Foyer updateFoyer(Foyer f) {

        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {

        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(Long idFoyer) {

        foyerRepository.deleteById(idFoyer);
    }
}

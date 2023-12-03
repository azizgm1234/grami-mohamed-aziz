package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Foyer;
import tn.esprit.se.projet1.repository.BlocRepository;
import tn.esprit.se.projet1.repository.FoyerRepository;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class FoyerService implements IFoyerService{
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;


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

    void archiverFoyer (long idFoyer){
        Optional<Foyer> optionalFoyer = foyerRepository.findById(idFoyer);
        if (optionalFoyer.isPresent()) {
            Foyer foyer = optionalFoyer.get();
            foyer.setArchived(true);
            foyerRepository.save(foyer);
        }
}

    @Override
    public Foyer addFoyerWithBloc(Foyer f) {
        foyerRepository.save(f);
        f.getBloc().forEach(bloc -> {
            bloc.setFoyer(f);
            blocRepository.save(bloc);
        });
        return f;
    }

}

package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Chambre;
import tn.esprit.se.projet1.repository.ChambreRepository;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
   ChambreRepository chambreRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}

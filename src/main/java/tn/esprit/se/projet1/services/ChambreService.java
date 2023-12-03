package tn.esprit.se.projet1.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.se.projet1.entites.Bloc;
import tn.esprit.se.projet1.entites.Chambre;
import tn.esprit.se.projet1.entites.TypeChambre;
import tn.esprit.se.projet1.repository.BlocRepository;
import tn.esprit.se.projet1.repository.ChambreRepository;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
   ChambreRepository chambreRepository;
   BlocRepository blocRepository;
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

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findBynomBloc(nomBloc);

        if (bloc != null) {
            for (Long numero : numChambre) {
                Chambre chambre = chambreRepository.findByNumeroChambre(numero);
                chambre.setBloc(bloc);
                chambreRepository.save(chambre);
            }
            blocRepository.save(bloc);
            return bloc;
        } else {
            // Handle the case when Bloc with the given nomBloc is not found
            return null;
        }
    }
    @Override
    public Bloc desaffecterChambreDeBloc(List<Long> numChambre) {
        for (Long numero : numChambre) {
            Chambre chambre = chambreRepository.findByNumeroChambre(numero);
            if (chambre != null) {
                chambre.setBloc(null);
                chambreRepository.save(chambre);
            }
        }
        return null;
    }
    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc bloc = blocRepository.findBynomBloc(nomBloc);
        Set<Chambre> chambres = bloc.getChambres();
        List<Chambre> chambreList = new ArrayList<>(chambres);
        chambreList.forEach(ch->{
            log.info("num" +ch.getNumeroChambre());
        });
return chambreList;
    }

    @Override
    public List<Long> getChambresParNomBloc2(String nomBloc) {
        Bloc bloc = blocRepository.findBynomBloc(nomBloc);

        if (bloc != null) {
            Set<Chambre> chambres = bloc.getChambres();
            List<Long> chambreNumbers = new ArrayList<>();

            chambres.forEach(ch -> {
                chambreNumbers.add(ch.getNumeroChambre());
            });

            return chambreNumbers;
        } else {

            return Collections.emptyList();
        }
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc){
        Bloc bloc = blocRepository.findById(idBloc).get();
        Set<Chambre> chambres = bloc.getChambres();
        List<Chambre> chambreList = new ArrayList<>();
        chambres.forEach(ch ->{
            if(ch.getTypecC()==type){
                chambreList.add(ch);
            }

        });

        return chambreList.size();
    }



    @Scheduled(fixedRate = 10000)
    void listeChambresParBloc() {
        List<Bloc> blocs = blocRepository.findAll();
        blocs.forEach(bloc -> {
            log.info("nom du bloc : " + bloc.getNomBloc() + " ayant une capacité " + bloc.getCapaciteBloc());
            log.info("liste des chambres : " + bloc.getNomBloc());

            bloc.getChambres().forEach(cha ->
                    log.info("chambre numero " + cha.getNumeroChambre() + " de type " + cha.getTypecC())
            );
        });

    }
    @Scheduled(fixedRate = 50000)
    public void pourcentageChambreParTypeChambre() {

        List<Chambre> chambres = chambreRepository.findAll();
        int nbTotalChambres = chambres.size();

        log.info("nbTotalsChambres : {}", nbTotalChambres);

        for (TypeChambre typeChambre : TypeChambre.values()) {
            long countByType = chambres.stream()
                    .filter(chambre -> chambre.getTypecC() == typeChambre)
                    .count();

            double percentage = (countByType * 100.0) / nbTotalChambres;

            log.info("Le pourcentage des chambres de type {} est égal à {}", typeChambre, percentage );
        };

        log.info("fin de test poucentage");
    }




}

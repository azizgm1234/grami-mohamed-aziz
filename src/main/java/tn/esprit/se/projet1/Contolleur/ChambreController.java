package tn.esprit.se.projet1.Contolleur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.se.projet1.entites.Chambre;
import tn.esprit.se.projet1.services.IChambreService;



import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    IChambreService iChambreService;

    @GetMapping("/allChambre")
    public List<Chambre> getBloc() {
        List<Chambre> listChambres = iChambreService.retrieveAllChambres();
        return listChambres;
    }

    @GetMapping("/Chambre/{id}")
    public Chambre retrieveChambre(@PathVariable("id") Long id) {
        return iChambreService.retrieveChambre(id);
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = iChambreService.addChambre(c);
        return chambre;
    }

    @DeleteMapping("/RemoveChambre/{id}")
    public void removeChambre(@PathVariable("id") Long id) {
        iChambreService.removeChambre(id);
    }

    @PutMapping("/UpdateChambre")
    public Chambre updateBloc(@RequestBody Chambre c) {
        Chambre chambre= iChambreService.updateChambre(c);
        return chambre;
    }
}

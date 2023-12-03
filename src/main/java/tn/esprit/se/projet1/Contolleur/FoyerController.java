package tn.esprit.se.projet1.Contolleur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.se.projet1.entites.Foyer;
import tn.esprit.se.projet1.services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    IFoyerService iFoyerService;

    @GetMapping("/allFoyer")
    public List<Foyer> getFoyer() {
        List<Foyer> listFoyer = iFoyerService.retrieveAllFoyers();
        return listFoyer;
    }

    @GetMapping("/Foyer/{id}")
    public Foyer retrieveFoyer(@PathVariable("id") Long id) {
        return iFoyerService.retrieveFoyer(id);
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = iFoyerService.addFoyer(f);
        return foyer;
    }

    @DeleteMapping("/RemoveFoyer/{id}")
    public void removeFoyer(@PathVariable("id") Long id) {
        iFoyerService.removeFoyer(id);
    }

    @PutMapping("/UpdateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        Foyer foyer= iFoyerService.updateFoyer(f);
        return foyer;
    }
    @PutMapping("affecterFO")
    @ResponseBody
    public Foyer addFoyerWithBloc (Foyer foyer){
        Foyer foyer1 = iFoyerService.addFoyerWithBloc( foyer);
        return foyer1;

    }

}

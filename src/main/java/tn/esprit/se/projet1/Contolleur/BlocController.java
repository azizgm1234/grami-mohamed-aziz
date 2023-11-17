package tn.esprit.se.projet1.Contolleur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.se.projet1.entites.Bloc;
import tn.esprit.se.projet1.services.IBlocService;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    IBlocService iBlocService;

    @GetMapping("/allBloc")
    public List<Bloc> getBloc() {
        List<Bloc> listBlocs = iBlocService.retrieveAllBlocs();
        return listBlocs;
    }

    @GetMapping("/Bloc/{id}")
    public Bloc retrievebloc(@PathVariable("id") Long id) {

        return iBlocService.retrieveBloc(id);
    }

    @PostMapping("/addBloc")
    public Bloc addEtudiant(@RequestBody Bloc b) {
        Bloc bloc = iBlocService.addBloc(b);
        return bloc;
    }

    @DeleteMapping("/RemoveBloc/{id}")
    public void removeBloc(@PathVariable("id") Long id) {
        iBlocService.removeBloc(id);
    }

    @PutMapping("/UpdateBloc")
    public Bloc updateBloc(@RequestBody Bloc e) {
        Bloc bloc= iBlocService.updateBloc(e);
        return bloc;
    }


}

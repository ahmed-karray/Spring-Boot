package tp.esprit.tpfoyee.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.esprit.tpfoyee.Entites.Bloc;
import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {

    @Autowired
    private IBlocService blocService;

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addOrUpdateBloc(b);
    }

    @PutMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc b) {
        return blocService.addOrUpdateBloc(b);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBloc(@PathVariable("id") Long id) {
        blocService.deleteBloc(id);
    }

    @GetMapping("/findall")
    public List<Bloc> findAll() {
        return blocService.getAllBloc();
    }

    @GetMapping("/findById/{id}")
    public Bloc findById(@PathVariable("id") Long id) {
        return blocService.getBlocById(id);
    }

    @PutMapping("/assignBlocToFoyer/{idBloc}/{idFoyer}")
    @ResponseBody
    public void assignBlocToFoyer(@PathVariable("idBloc") Long idBloc,@PathVariable("idFoyer") Long idFoyer){
        blocService.assignBlocToFoyer(idBloc, idFoyer);
    }
    @PutMapping("/desaffecterBlocFromFoyer/{idBloc}")
    @ResponseBody
    public void desaffecterBlocFromFoyer(@PathVariable("idBloc") Long idBloc){
        blocService.DesaffecterBlocFromFoyer(idBloc);
    }

    @GetMapping("/nonAffectes")
    public List<Bloc> findByFoyerIsNull() {
        return blocService.findByFoyerIsNull();
    }

    @GetMapping("/capaciteGreaterThan/{capacite}")
    public List<Bloc> findByCapaciteBlocGreaterThan(@PathVariable("capacite") Long capacite) {
        return blocService.findByCapaciteBlocGreaterThan(capacite);
    }

    @GetMapping("/nomStartingWith/{prefix}")
    public List<Bloc> findByNomBlocStartingWith(@PathVariable("prefix") String prefix) {
        return blocService.findByNomBlocStartingWith(prefix);
    }

    @GetMapping("/nomStartingWithAndCapacite/{prefix}/{capacite}")
    public List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(
            @PathVariable("prefix") String prefix,
            @PathVariable("capacite") Long capacite) {
        return blocService.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(prefix, capacite);
    }

    @GetMapping("/findBlocsByChambres/{chambreId}")
    public List<Bloc> findBlocsByChambre(@PathVariable("chambreId") Long chambreId) {
        return blocService.findBlocsByChambre(chambreId);
    }

    @GetMapping("/groupByBlocAndType")
    public List<Object[]> groupByBlocAndType() {
        return blocService.groupByBlocAndTypeChambre();
    }

    @GetMapping("/blocChambreFoyer")
    public List<Object[]> getBlocChambreFoyer() {
        return blocService.getBlocChambreFoyer();
    }
}
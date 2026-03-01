package tp.esprit.tpfoyee.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.esprit.tpfoyee.Entites.Foyer;
import tp.esprit.tpfoyee.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor

public class FoyerController {
    @Autowired
    private IFoyerService foyerService;

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer foyer) { return foyerService.addOrUpdateFoyer(foyer); }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) { return foyerService.addOrUpdateFoyer(foyer); }

    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable("id") Long id) { foyerService.deleteFoyer(id);}

    @GetMapping("findall")
    public List<Foyer> findAllFoyer() { return foyerService.getAllFoyer(); }

    @GetMapping("findById/{id}")
    public Foyer findById(@PathVariable("id") Long id) { return foyerService.getFoyerById(id); }
}

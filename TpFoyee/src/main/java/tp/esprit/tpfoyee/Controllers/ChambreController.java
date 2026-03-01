package tp.esprit.tpfoyee.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.services.ChambreService;
import tp.esprit.tpfoyee.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {
    @Autowired
    private IChambreService chambreService;

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre chambre) { return chambreService.addOrUpdateChambre(chambre); }

    @PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre chambre) { return chambreService.addOrUpdateChambre(chambre); }

    @DeleteMapping("delete/{id}")
    public void deleteChambre(@PathVariable("id") Long id) { chambreService.deleteChambre(id); }

    @GetMapping("findall")
    public List<Chambre> findAll() { return chambreService.getAllChambre(); }

    @GetMapping("findById/{id}")
    public Chambre findById(@PathVariable("id") Long id) { return chambreService.getChambreById(id); }
}

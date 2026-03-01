package tp.esprit.tpfoyee.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.esprit.tpfoyee.Entites.Universite;
import tp.esprit.tpfoyee.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor

public class UniversiteController {
    @Autowired
    private IUniversiteService UniversiteService;

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite Universite) { return UniversiteService.addOrUpdateUniversite(Universite); }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite Universite) { return UniversiteService.addOrUpdateUniversite(Universite); }

    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable("id") Long id) { UniversiteService.deleteUniversite(id);}

    @GetMapping("findall")
    public List<Universite> findAllUniversite() { return UniversiteService.getAllUniversite(); }

    @GetMapping("findById/{id}")
    public Universite findById(@PathVariable("id") Long id) { return UniversiteService.getUniversiteById(id); }

}

package tp.esprit.tpfoyee.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.esprit.tpfoyee.Entites.Etudiant;
import tp.esprit.tpfoyee.services.EtudiantService;
import tp.esprit.tpfoyee.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor

public class EtudiantContoller {
    @Autowired
    private IEtudiantService etudiantService;

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) { return etudiantService.addOrUpdateProjet(etudiant); }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) { return etudiantService.addOrUpdateProjet(etudiant); }

    @DeleteMapping("delete/{id}")
    public void deleteEtudiant(@PathVariable("id") Long id ) { etudiantService.deleteEtudiant(id); }

    @GetMapping("findall")
    public List<Etudiant> findAllEtudiant() { return etudiantService.getAllEtudiant(); }

    @GetMapping("findById/{id}")
    public Etudiant findById(@PathVariable("id") Long id) { return etudiantService.getEtudiantById(id); }
}

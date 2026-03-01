package tp.esprit.tpfoyee.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.esprit.tpfoyee.Entites.bloc;
import tp.esprit.tpfoyee.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {

    @Autowired
    private IBlocService blocService;

    @PostMapping("/add")
    public bloc addBloc(@RequestBody bloc b) {
        return blocService.addOrUpdateBloc(b);
    }

    @PutMapping("/update")
    public bloc updateBloc(@RequestBody bloc b) {
        return blocService.addOrUpdateBloc(b);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBloc(@PathVariable("id") Long id) {
        blocService.deleteBloc(id);
    }

    @GetMapping("/findall")
    public List<bloc> findAll() {
        return blocService.getAllBloc();
    }

    @GetMapping("/findById/{id}")
    public bloc findById(@PathVariable("id") Long id) {
        return blocService.getBlocById(id);
    }
}
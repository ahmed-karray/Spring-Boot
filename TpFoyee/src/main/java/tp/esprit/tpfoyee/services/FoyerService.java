package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.Foyer;
import tp.esprit.tpfoyee.Repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;
    @Override
    public Foyer addOrUpdateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }
}

package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.Universite;
import tp.esprit.tpfoyee.Repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class UniversiteService implements IUniversiteService {
    UniversiteRepository universiteRepository;

    @Override
    public Universite addOrUpdateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }
}

package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.Repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class ChambreService implements IChambreService {
    ChambreRepository ChambreRepository;

    @Override
    public Chambre addOrUpdateChambre(Chambre Chambre) {
        return ChambreRepository.save(Chambre);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return ChambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return ChambreRepository.findAll();
    }

    @Override
    public void deleteChambre(Long id) {
        ChambreRepository.deleteById(id);

    }
}

package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.bloc;
import tp.esprit.tpfoyee.Repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository blocRepository;

    @Override
    public bloc addOrUpdateBloc(bloc b) {
        if (b.getIdBloc() != null && !blocRepository.existsById(b.getIdBloc())) {
            throw new RuntimeException("Bloc with id " + b.getIdBloc() + " not found");
        }
        return blocRepository.save(b);
    }

    @Override
    // Inside your BlocServiceImpl.java
    public bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public List<bloc> getAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }
}
package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.Bloc;
import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.Entites.Foyer;
import tp.esprit.tpfoyee.Repositories.BlocRepository;
import tp.esprit.tpfoyee.Repositories.ChambreRepository;
import tp.esprit.tpfoyee.Repositories.FoyerRepository;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    private final FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public Bloc addOrUpdateBloc(Bloc b) {
        if (b.getIdBloc() != null && !blocRepository.existsById(b.getIdBloc())) {
            throw new RuntimeException("Bloc with id " + b.getIdBloc() + " not found");
        }
        return blocRepository.save(b);
    }

    @Override
    // Inside your BlocServiceImpl.java
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public void assignBlocToFoyer(Long idBloc, Long idFoyer) {
        Bloc b = blocRepository.findById(idBloc).get();
        Foyer f = foyerRepository.findById(idFoyer).get();
        b.setFoyer(f);
        blocRepository.save(b);
    }

    @Override
    public void DesaffecterBlocFromFoyer(Long idBloc) {
        Bloc b = blocRepository.findById(idBloc).get();
        b.setFoyer(null);
        blocRepository.save(b);
    }

    @Override
    public List<Bloc> findByFoyerIsNull() {
        return blocRepository.findByFoyerIsNull();
    }

    @Override
    public List<Bloc> findByCapaciteBlocGreaterThan(Long capacite) {
        return blocRepository.findByCapaciteBlocGreaterThan(capacite);
    }
    @Override
    public List<Bloc> findByNomBlocStartingWith(String prefix){
        return blocRepository.findByNomBlocStartingWith(prefix);
    }

    @Override
    public List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String prefix, Long capacite) {
        return blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(prefix, capacite);
    }

    @Override
    public List<Bloc> findBlocsByChambre(Long chambreId) {
        Chambre chambre = chambreRepository.findById(chambreId).get();
        return blocRepository.findBlocsByChambre(chambre);
    }

    @Override
    public List<Object[]> groupByBlocAndTypeChambre(){
        return blocRepository.groupByBlocAndTypeChambre();
    }

    @Override
    public List<Object[]> getBlocChambreFoyer(){
        return blocRepository.getBlocChambreFoyer();
    }
}
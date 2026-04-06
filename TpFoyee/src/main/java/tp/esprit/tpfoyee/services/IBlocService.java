package tp.esprit.tpfoyee.services;

import org.springframework.data.repository.query.Param;
import tp.esprit.tpfoyee.Entites.Bloc;
import tp.esprit.tpfoyee.Entites.Chambre;

import java.util.List;
import java.util.Objects;

public interface IBlocService {
    Bloc addOrUpdateBloc(Bloc bloc);
    Bloc getBlocById(Long id);
    List<Bloc> getAllBloc();
    void deleteBloc(Long id);
    void assignBlocToFoyer(Long idBloc, Long idFoyer);
    void DesaffecterBlocFromFoyer(Long idBloc);
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);
    List<Bloc> findByNomBlocStartingWith(String prefix);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String prefix, Long capacite);
    List<Bloc> findBlocsByChambre(Long chambreId);
    List<Object[]> groupByBlocAndTypeChambre();
    List<Object[]> getBlocChambreFoyer();


}


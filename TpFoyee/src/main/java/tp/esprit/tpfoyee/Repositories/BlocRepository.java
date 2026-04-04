package tp.esprit.tpfoyee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.tpfoyee.Entites.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);
    List<Bloc> findByNomBlocStartingWith(String prefix);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String prefix, Long capacite);

}

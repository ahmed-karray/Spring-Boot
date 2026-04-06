package tp.esprit.tpfoyee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp.esprit.tpfoyee.Entites.Bloc;
import tp.esprit.tpfoyee.Entites.Chambre;

import java.util.List;
import java.util.Objects;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
    List<Bloc> findByFoyerIsNull();
    List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);
    List<Bloc> findByNomBlocStartingWith(String prefix);
    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String prefix, Long capacite);
    @Query("select b from Bloc b where :chambre MEMBER OF b.chambres")
    List<Bloc> findBlocsByChambre(@Param("chambre") Chambre chambre);
    @Query("SELECT b.nomBloc, b.capaciteBloc, c.typeChambre, COUNT(c) " +
            "FROM Bloc b JOIN b.chambres c " +
            "GROUP BY b.capaciteBloc, c.typeChambre ")
    List<Object[]> groupByBlocAndTypeChambre();
    @Query("SELECT b.nomBloc, b.capaciteBloc, c.numeroChambre, c.typeChambre, f.nomFoyer " +
            "FROM Foyer f JOIN f.blocs b JOIN b.chambres c ")
    List<Object[]> getBlocChambreFoyer();
}

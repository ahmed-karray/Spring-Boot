package tp.esprit.tpfoyee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.Entites.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByTypeChambre(TypeChambre typeChambre);

    Chambre findByNumeroChambre(Long numeroChambre);
}

package tp.esprit.tpfoyee.services;

import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.Entites.Foyer;
import tp.esprit.tpfoyee.Entites.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdateChambre(Chambre Chambre);
    Chambre getChambreById(Long id);
    List<Chambre> getAllChambre();
    void deleteChambre(Long id);
    Chambre addChambreEtReservationAssocie(Chambre c);
    List<Chambre> findByTypeChambre(TypeChambre typeChambre);
    Chambre findByNumeroChambre(Long numeroChambre);

}

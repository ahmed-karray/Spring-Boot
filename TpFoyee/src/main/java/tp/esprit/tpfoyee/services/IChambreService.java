package tp.esprit.tpfoyee.services;

import tp.esprit.tpfoyee.Entites.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre addOrUpdateChambre(Chambre Chambre);
    Chambre getChambreById(Long id);
    List<Chambre> getAllChambre();
    void deleteChambre(Long id);
}

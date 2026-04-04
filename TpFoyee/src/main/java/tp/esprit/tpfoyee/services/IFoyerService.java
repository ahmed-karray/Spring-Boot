package tp.esprit.tpfoyee.services;

import tp.esprit.tpfoyee.Entites.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addOrUpdateFoyer(Foyer foyer);
    Foyer getFoyerById(Long id);
    List<Foyer> getAllFoyer();
    void deleteFoyer(Long id);
    Foyer addFoyerEtBlocAssocie(Foyer f);
}

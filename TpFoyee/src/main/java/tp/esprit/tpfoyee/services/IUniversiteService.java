package tp.esprit.tpfoyee.services;

import tp.esprit.tpfoyee.Entites.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addOrUpdateUniversite(Universite universite);
    Universite getUniversiteById(Long id);
    List<Universite> getAllUniversite();
    void deleteUniversite(Long id);
}

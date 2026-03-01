package tp.esprit.tpfoyee.services;

import tp.esprit.tpfoyee.Entites.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdateProjet(Etudiant etudiant);
    Etudiant getEtudiantById(Long id);
    List<Etudiant> getAllEtudiant();
    void deleteEtudiant(Long id);
}

package tp.esprit.tpfoyee.services;

import tp.esprit.tpfoyee.Entites.bloc;

import java.util.List;

public interface IBlocService {
    bloc addOrUpdateBloc(bloc bloc);
    bloc getBlocById(Long id);
    List<bloc> getAllBloc();
    void deleteBloc(Long id);
}


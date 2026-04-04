package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.Entites.TypeChambre;
import tp.esprit.tpfoyee.Repositories.ChambreRepository;
import tp.esprit.tpfoyee.Repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class ChambreService implements IChambreService {
    private final ReservationRepository reservationRepository;
    ChambreRepository ChambreRepository;

    @Override
    public Chambre addOrUpdateChambre(Chambre Chambre) {
        return ChambreRepository.save(Chambre);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return ChambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return ChambreRepository.findAll();
    }

    @Override
    public void deleteChambre(Long id) {
        ChambreRepository.deleteById(id);

    }

    @Override
    public Chambre addChambreEtReservationAssocie(Chambre c) {
        Chambre chambre = ChambreRepository.save(c);
        chambre.getReservations().forEach(reservation -> {
            reservation.setChambre(chambre);
                    reservationRepository.save(reservation);
                }
                );
        return chambre;
    }

    @Override
    public List<Chambre> findByTypeChambre(TypeChambre typeChambre) {
        return ChambreRepository.findByTypeChambre(typeChambre);
    }

    @Override
    public Chambre findByNumeroChambre(Long numeroChambre) {
        return ChambreRepository.findByNumeroChambre(numeroChambre);
    }
}

package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.Chambre;
import tp.esprit.tpfoyee.Entites.Reservation;
import tp.esprit.tpfoyee.Repositories.ChambreRepository;
import tp.esprit.tpfoyee.Repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    private final ChambreRepository chambreRepository;
    ReservationRepository reservationRepository;

    @Override
    public Reservation addOrUpdateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void assignReservationToChambre(String idReservation, Long idChambre) {
        Reservation r = reservationRepository.findById(idReservation).get();
        Chambre c = chambreRepository.findById(idChambre).get();
        r.setChambre(c);
        reservationRepository.save(r);
    }

    @Override
    public void DesaffecterReservationFromChambre(String idReservation) {
        Reservation r = reservationRepository.findById(idReservation).get();
        r.setChambre(null);
        reservationRepository.save(r);
    }
}

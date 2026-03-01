package tp.esprit.tpfoyee.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tp.esprit.tpfoyee.Entites.Reservation;
import tp.esprit.tpfoyee.Repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
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
}

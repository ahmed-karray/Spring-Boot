package tp.esprit.tpfoyee.services;

import tp.esprit.tpfoyee.Entites.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addOrUpdateReservation(Reservation reservation);
    Reservation getReservationById(String id);
    List<Reservation> getAllReservation();
    void deleteReservation(String id);
}

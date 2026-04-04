package tp.esprit.tpfoyee.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.esprit.tpfoyee.Entites.Reservation;
import tp.esprit.tpfoyee.Repositories.ReservationRepository;
import tp.esprit.tpfoyee.services.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor

public class ReservationController {
    @Autowired
    private IReservationService ReservationService;

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation Reservation) { return ReservationService.addOrUpdateReservation(Reservation); }

    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation Reservation) { return ReservationService.addOrUpdateReservation(Reservation); }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable("id") String id) { ReservationService.deleteReservation(id);}

    @GetMapping("findall")
    public List<Reservation> findAllReservation() { return ReservationService.getAllReservation(); }

    @GetMapping("findById/{id}")
    public Reservation findById(@PathVariable("id") String id) { return ReservationService.getReservationById(id); }

    @PutMapping("/assignReservationToChambre/{idReservation}/{idChambre}")
    @ResponseBody
    public void assignReservationToChambre(@PathVariable("idReservation") String idReservation,@PathVariable("idChambre") Long idChambre){
        ReservationService.assignReservationToChambre(idReservation, idChambre);
    }
    @PutMapping("/desaffecterReservationFromChambre/{idReservation}")
    @ResponseBody
    public void desaffecterReservationFromChambre(@PathVariable("idReservation") String idReservation){
        ReservationService.DesaffecterReservationFromChambre(idReservation);
    }

}

package tp.esprit.tpfoyee.Entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"etudiants"})


public class Reservation {
    @Id
    String idReservation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // ✅ Add this
    Date anneeUniversitaire;
    Boolean estValid;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Etudiant> etudiants;
}

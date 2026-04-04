package tp.esprit.tpfoyee.Entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"etudiants", "chambre"})


public class Reservation {
    @Id
    String idReservation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // ✅ Add this
    Date anneeUniversitaire;
    Boolean estValide;

    @ManyToMany
    @JsonIgnore
    Set<Etudiant> etudiants;

    @ManyToOne
    @JsonIgnore
    Chambre chambre;
}

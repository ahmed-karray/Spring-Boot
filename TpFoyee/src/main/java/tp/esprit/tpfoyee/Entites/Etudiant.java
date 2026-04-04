package tp.esprit.tpfoyee.Entites;

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
@ToString(exclude = {"reservations"})

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idEtudiant;
    String nomEt;
    String prenomEt;
    Long cin;
    String ecole;
    Date dateNaissance;

    @ManyToMany(mappedBy ="etudiants")
    @JsonIgnore
    Set<Reservation> reservations;
}

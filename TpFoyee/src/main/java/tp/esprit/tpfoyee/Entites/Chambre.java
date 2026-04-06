package tp.esprit.tpfoyee.Entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"reservations", "bloc"}) // ✅ Only change: prevent StackOverflow


public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idChambre;
    Long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chambre")
    //@JsonIgnore
    Set<Reservation> reservations;

    @ManyToOne()
    //@JsonIgnore
    @JsonBackReference
    Bloc bloc;

}

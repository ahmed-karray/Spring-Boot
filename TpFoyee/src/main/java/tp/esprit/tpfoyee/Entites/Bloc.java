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
@ToString(exclude = {"chambres", "foyer"}) // ✅ Only change: prevent StackOverflow

public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idBloc;
    String nomBloc;
    Long capaciteBloc;
    @ManyToOne
    //@JsonIgnore
    @JsonBackReference

    Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    @JsonIgnore
    Set<Chambre> chambres;

}

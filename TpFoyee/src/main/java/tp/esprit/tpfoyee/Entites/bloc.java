package tp.esprit.tpfoyee.Entites;

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

public class bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idBloc;
    String nomBloc;
    Long capaciteBloc;
    @ManyToOne
    @JsonIgnore
    Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    @JsonIgnore
    Set<Chambre> chambres;

}

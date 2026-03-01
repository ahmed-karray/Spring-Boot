package tp.esprit.tpfoyee.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"foyer"})

public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUniversite;
    String nomUniversite;
    String addresse;

    @OneToOne
    @JsonIgnore
    Foyer foyer;
}

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
@ToString(exclude = {"universites", "bloc"})

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idFoyer;
    String nomFoyer;
    Long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    Universite universite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    @JsonIgnore
    Set<bloc> blocs;
}

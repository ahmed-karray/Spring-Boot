package tp.esprit.tpfoyee.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"universite", "bloc"})

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
    //@JsonIgnore
    @JsonManagedReference
    Set<Bloc> blocs;
}

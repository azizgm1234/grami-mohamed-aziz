package tn.esprit.se.projet1.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter // tebaa e lobok generer auto au moment de la compilation
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idChambre")
    private Long idChambre; // Clé primaire
    private Long numeroChambre;
    @Enumerated (EnumType.STRING)
    TypeChambre typecC;


    @ManyToOne// chambre bloc
    Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}



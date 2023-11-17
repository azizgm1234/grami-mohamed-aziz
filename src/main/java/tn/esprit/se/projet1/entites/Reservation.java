
package tn.esprit.se.projet1.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter // tebaa e lobok generer auto au moment de la compilation
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    @Column(name="idReservation")
    private String idReservation; // Clé primaire
    private Boolean estValide;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;


@ManyToMany(cascade = CascadeType.ALL)//etudiant reservation
private Set<Etudiant> etudiant;
}



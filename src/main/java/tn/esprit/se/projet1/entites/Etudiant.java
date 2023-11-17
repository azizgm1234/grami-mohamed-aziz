package tn.esprit.se.projet1.entites;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter // tebaa e lobok generer auto au moment de la compilation
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Table( name = "Etudiant")//tbadel biha esm lclasse
public class Etudiant implements Serializable {//forma byte wbaed save aand serveur
    @Id//primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")//colonne tepointi sur object etudiant "zeyda"
    private Long idEtudiant; // Clé primaire
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;
    LocalDate dateNaissance;



    @ManyToMany(mappedBy="etudiant", cascade = CascadeType.ALL)//etudiant reservation
    private Set<Reservation> reservations;




//@getter genere getter pour tous les attribus au moment de la compilation


}




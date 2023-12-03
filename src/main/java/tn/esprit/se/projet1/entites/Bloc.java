package tn.esprit.se.projet1.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.se.projet1.entites.Chambre;
import tn.esprit.se.projet1.entites.Foyer;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter // tebaa e lobok generer auto au moment de la compilation
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Table( name = "Bloc")
public class Bloc  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBloc")
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;
    @JsonIgnore
    @ManyToOne
    Foyer foyer;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc", fetch = FetchType.EAGER)//bloc chambre
    private Set<Chambre> chambres;

}
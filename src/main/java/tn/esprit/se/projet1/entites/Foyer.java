package tn.esprit.se.projet1.entites;
        import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Foyer implements Serializable {
    @Id//primary key
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idFoyer")
    private Long idFoyert; // Clé primaire
    private String nomFoyer;
    private Long capcitefoyer;
    private boolean archived = false;
// Constructeur et accesseurs (getters) et mutateurs (setters)
@JsonIgnore
@OneToOne(mappedBy="foyer") //foyer universite
private Universite universite;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    private Set<Bloc> bloc;



}

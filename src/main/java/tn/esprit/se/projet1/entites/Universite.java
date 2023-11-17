package tn.esprit.se.projet1.entites;
        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import java.io.Serializable;


@Entity
@Getter // tebaa e lobok generer auto au moment de la compilation
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite implements Serializable {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private Long idUniversite; // Clé primaire
    private String nomUniveriste;
    private String adresse;
// Constructeur et accesseurs (getters) et mutateurs (setters)

    @OneToOne
    private Foyer foyer;
}

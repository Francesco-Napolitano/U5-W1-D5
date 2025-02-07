package it.franapo.last_exercise.edificio;

import it.franapo.last_exercise.postazione.Postazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "edificio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String indirizzo;

    @Column(nullable = false, length = 50)
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazione;

}

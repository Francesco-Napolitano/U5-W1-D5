package it.franapo.last_exercise.postazione;

import it.franapo.last_exercise.edificio.Edificio;
import it.franapo.last_exercise.prenotazione.Prenotazione;
import it.franapo.last_exercise.tipo.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postazioni")

public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String descrizione;

    @Column(nullable = false)
    private Tipo tipo;

    @Column(nullable = false)
    private int numeroPosti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToOne
    @JoinColumn(name = "prenotazione_id")
    private Prenotazione prenotazione;

}

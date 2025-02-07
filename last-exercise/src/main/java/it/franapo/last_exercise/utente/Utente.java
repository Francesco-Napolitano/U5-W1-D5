package it.franapo.last_exercise.utente;

import it.franapo.last_exercise.prenotazione.Prenotazione;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "utente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String realName;

    @Column(nullable = false, length = 50)
    private String email;

    @OneToMany(mappedBy = "utente")
    private Set<Prenotazione> prenotazione;


}

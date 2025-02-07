package it.franapo.last_exercise.utente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {

    @Id
    private Long username;

    @Column(nullable = false, length = 50)
    private String realName;

    @Column(nullable = false, length = 50)
    private String email;


}

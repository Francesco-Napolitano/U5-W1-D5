package it.franapo.last_exercise.postazione;


import it.franapo.last_exercise.tipo.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

}

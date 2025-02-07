package it.franapo.last_exercise;

import com.github.javafaker.Faker;
import it.franapo.last_exercise.edificio.Edificio;
import it.franapo.last_exercise.edificio.EdificioRepository;
import it.franapo.last_exercise.postazione.Postazione;
import it.franapo.last_exercise.postazione.PostazioneRepository;
import it.franapo.last_exercise.prenotazione.Prenotazione;
import it.franapo.last_exercise.prenotazione.PrenotazioneRepository;
import it.franapo.last_exercise.tipo.Tipo;
import it.franapo.last_exercise.utente.Utente;
import it.franapo.last_exercise.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Order(1)
public class CreateDBRunner implements CommandLineRunner {
    private final EdificioRepository edificioRepository;
    private final PostazioneRepository postazioneRepository;
    private final UtenteRepository utenteRepository;
    private final PrenotazioneRepository prenotazioneRepository;
    private final Faker faker = new Faker();
    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Edificio edificio = new Edificio();
            edificio.setNome(faker.company().name());
            edificio.setIndirizzo(faker.address().streetAddress());
            edificio.setCitta(faker.address().city());
            edificioRepository.save(edificio);
        }

        List<Edificio> edifici = edificioRepository.findAll();

        for (int i = 0; i < 10; i++) {
            Postazione postazione = new Postazione();
            postazione.setDescrizione(faker.company().name());
            postazione.setEdificio(edifici.get(random.nextInt(edifici.size())));
            postazione.setNumeroPosti(random.nextInt(20));
            postazione.setTipo(Tipo.values()[random.nextInt(Tipo.values().length)]);
            postazioneRepository.save(postazione);
        }
        List<Postazione> postazioni = postazioneRepository.findAll();

        for (int i = 0; i < 10; i++) {
            Utente utente = new Utente();
            utente.setRealName(faker.name().fullName());
            utente.setUsername(faker.bothify("??-###"));
            utente.setEmail(faker.internet().emailAddress());
            utenteRepository.save(utente);
        }

        List<Utente> utenti = utenteRepository.findAll();

        for (int i = 0; i < 5; i++) {
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setData(LocalDate.parse(LocalDate.now().plusDays(i).toString()));
            prenotazione.setUtente(utenti.get(random.nextInt(utenti.size())));
            prenotazione.setPostazione(postazioni.get(random.nextInt(postazioni.size())));
            prenotazioneRepository.save(prenotazione);
        }

        System.out.println("Database popolato con successo!");
    }

}

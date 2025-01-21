package se.lexicon.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.library.entity.AppUser;
import se.lexicon.library.entity.Details;
import se.lexicon.library.repository.AppUserRepository;
import se.lexicon.library.repository.DetailsRepository;

import java.time.LocalDate;

@Component
public class TestRe implements CommandLineRunner {
    AppUserRepository appUserRepository;
    DetailsRepository detailsRepository;
    @Autowired
    public TestRe (AppUserRepository appUserRepository, DetailsRepository detailsRepository) {
        this.appUserRepository = appUserRepository;
        this.detailsRepository = detailsRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        appUserRepository.save(new AppUser("John", "Doe"));
        detailsRepository.save(new Details("jack","asd", LocalDate.parse("1992-06-06")));

    }
}

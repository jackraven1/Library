package se.lexicon.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.library.repository.AppUserRepository;
import se.lexicon.library.repository.DetailsRepository;
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


    }
}

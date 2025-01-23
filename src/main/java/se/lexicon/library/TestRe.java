package se.lexicon.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.library.entity.*;
import se.lexicon.library.repository.*;
import java.time.LocalDate;

@Component
public class TestRe implements CommandLineRunner {
    AppUserRepository appUserRepository;
    DetailsRepository detailsRepository;
    AuthorRepository authorRepository;
    BookLoanRepo bookLoanRepo;
    BookRepo bookRepo;
    @Autowired
    public TestRe (AppUserRepository appUserRepository, DetailsRepository detailsRepository, AuthorRepository authorRepository, BookLoanRepo bookLoanRepo, BookRepo bookRepo) {
        this.appUserRepository = appUserRepository;
        this.detailsRepository = detailsRepository;
        this.authorRepository = authorRepository;
        this.bookLoanRepo = bookLoanRepo;
        this.bookRepo = bookRepo;
    }
    @Override
    public void run(String... args) throws Exception {
        appUserRepository.save(new AppUser("John", "Doe",null));
        detailsRepository.save(new Details("jack","asd", LocalDate.parse("1992-06-06")));
        appUserRepository.save(new AppUser("Jane", "Doe",null));
        Book book1 = new Book("215", "The Great Adventure", 5);
        Author author = new Author("jack","asd",null);
        bookRepo.save(book1);
        author.addWrittenBook(book1);
        authorRepository.save(author);
        bookLoanRepo.save(new BookLoan(
                LocalDate.parse("1992-05-01"),
                LocalDate.parse("1992-06-06"),
                false));

    }
}

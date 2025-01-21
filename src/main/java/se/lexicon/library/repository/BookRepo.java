package se.lexicon.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.library.entity.Book;

import java.util.List;
@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {
    Book findBookByIsbnIgnoreCase(String isbn);
    List<Book> findBooksByTitleContains(String title);
    List<Book> findBooksByMaxLoanDaysLessThan(int maxLoanDays);
}

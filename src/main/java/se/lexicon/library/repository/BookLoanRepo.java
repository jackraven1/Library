package se.lexicon.library.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.library.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;
@Repository
@Transactional
public interface BookLoanRepo extends CrudRepository<BookLoan, Integer> {
    List<BookLoan> findByBorrowerId(int borrowerId);
    List<BookLoan> findByBookId(int bookId);
    List<BookLoan> findByReturnedFalse();
    List<BookLoan> findByDueDateBeforeAndReturnedFalse(LocalDate dueDate);
    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);
    @Modifying
    @Query("UPDATE BookLoan b SET b.returned = TRUE WHERE b.id = :book_id")
    void updateReturnedTrue(int book_id);
}

package se.lexicon.library.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.lexicon.library.entity.Author;

import java.util.List;
import java.util.Set;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    List<Author> findByFirstNameOrLastNameContaining(String firstName, String lastName);
    Set<Author> findByWrittenBooksId(Integer bookId);
    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.firstName = :firstName,a.lastName = :lastName where a.id= :id")
    void UpdateFirstNameAndLastNameById(int id,String firstName, String lastName);

   @Modifying
   @Transactional
   @Query("DELETE FROM Author a WHERE a.id = :id")
   void DeleteAuthorById(Integer id);
}

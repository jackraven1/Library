package se.lexicon.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.library.entity.AppUser;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findByUserNameIs(String username);
    List<AppUser> findByRegDateBetween(LocalDate regDateAfter, LocalDate regDateBefore);

    @Query("SELECT u FROM AppUser u WHERE u.userDetails.id = :detailsId")
    List<AppUser> findUsersByDetailsId(@Param("detailsId") int detailsId);

    @Query("SELECT u FROM AppUser u WHERE LOWER(u.userDetails.email) = LOWER(:email)")
    AppUser findByEmail(@Param("email") String email);


}

package se.lexicon.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.library.entity.Details;
@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> {
    Details findDetailsByEmail(String email);

    Details findDetailsByNameContains(String name);

    Details findDetailsByNameIgnoreCase(String name);
}

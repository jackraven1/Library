package se.lexicon.library.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.library.entity.Details;

public interface DetailsRepository extends CrudRepository<Details, Integer> {
    Details findDetailsByEmail(String email);

    Details findDetailsByNameContains(String name);

    Details findDetailsByNameIgnoreCase(String name);
}

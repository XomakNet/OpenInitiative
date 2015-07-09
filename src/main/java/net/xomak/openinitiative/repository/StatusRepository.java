package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StatusRepository extends CrudRepository<Status, Long>{
    Status findById(final long id);
    Iterable<Status> findByIsSearchable(boolean isSearchable);
}

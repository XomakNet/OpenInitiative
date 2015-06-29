package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.Initiative;
import net.xomak.openinitiative.model.InitiativeCategory;
import net.xomak.openinitiative.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InitiativeRepository extends CrudRepository<Initiative, Long> {
    Page<Initiative> findByCategories(Collection<InitiativeCategory> categories, Pageable pageable);
    Page<Initiative> findByStatus(Status status, Pageable pageable);
}

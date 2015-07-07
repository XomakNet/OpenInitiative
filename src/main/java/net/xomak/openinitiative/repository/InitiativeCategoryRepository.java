package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.InitiativeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface InitiativeCategoryRepository extends CrudRepository<InitiativeCategory, Long> {
    public Iterable<InitiativeCategory> findByIsActive(boolean isActive);
}

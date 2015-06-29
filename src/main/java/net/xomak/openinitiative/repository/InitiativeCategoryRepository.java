package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.InitiativeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitiativeCategoryRepository extends CrudRepository<InitiativeCategory, Long> {

}

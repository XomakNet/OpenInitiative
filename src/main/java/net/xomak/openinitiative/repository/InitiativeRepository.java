package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.Initiative;
import net.xomak.openinitiative.model.InitiativeCategory;
import net.xomak.openinitiative.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface InitiativeRepository extends CrudRepository<Initiative, Long> {
    Page<Initiative> findByCategories(Collection<InitiativeCategory> categories, Pageable pageable);
    Page<Initiative> findByStatus(Status status, Pageable pageable);
    Page<Initiative> findAll(Pageable pageable);
    Page<Initiative> findByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase(String name, String description, Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query("update Initiative initiative set initiative.votesFor = initiative.votesFor+1 where initiative.id =:initiativeId")
    void increaseVotesFor(@Param("initiativeId") long initiativeId);

    @Modifying(clearAutomatically = true)
    @Query("update Initiative initiative set initiative.votesAgainst = initiative.votesAgainst+1 where initiative.id =:initiativeId")
    void increaseVotesAgainst(@Param("initiativeId") long initiativeId);


    long countByCategories(InitiativeCategory category);
}

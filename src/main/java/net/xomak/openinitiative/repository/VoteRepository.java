package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.Initiative;
import net.xomak.openinitiative.model.User;
import net.xomak.openinitiative.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by regis on 10.07.2015.
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {
    Vote findByUserAndInitiative(User user, Initiative initiative);
}

package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User, Long> {
    public User findByLoginAndPasswordHash(String login, String passwordHash);
    public User findByLogin(String login);
}

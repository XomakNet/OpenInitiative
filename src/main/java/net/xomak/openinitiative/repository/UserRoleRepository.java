package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by regis on 06.07.2015.
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    public UserRole findById(long id);
}

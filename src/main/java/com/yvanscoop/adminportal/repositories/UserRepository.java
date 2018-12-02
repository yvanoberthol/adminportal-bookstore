package com.yvanscoop.adminportal.repositories;

import com.yvanscoop.adminportal.entities.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}

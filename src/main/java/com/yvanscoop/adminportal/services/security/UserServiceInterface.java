package com.yvanscoop.adminportal.services.security;

import com.yvanscoop.adminportal.entities.security.User;
import com.yvanscoop.adminportal.entities.security.UserRole;

import java.util.Set;

public interface UserServiceInterface {

    User findByUsername(String username);
    User createUser(User user, Set<UserRole> userRoles) throws Exception;
    User saveUser(User user);
    void deleteUser(User user);
}

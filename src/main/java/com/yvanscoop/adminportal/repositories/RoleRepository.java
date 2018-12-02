package com.yvanscoop.adminportal.repositories;

import com.yvanscoop.adminportal.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

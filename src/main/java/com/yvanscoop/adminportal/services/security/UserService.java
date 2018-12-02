package com.yvanscoop.adminportal.services.security;

import com.yvanscoop.adminportal.entities.security.User;
import com.yvanscoop.adminportal.entities.security.UserRole;
import com.yvanscoop.adminportal.repositories.RoleRepository;
import com.yvanscoop.adminportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserService implements UserServiceInterface{


    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;



    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser != null){
            throw new Exception("user already exists. Nothing will be done");
        }else{
            for (UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user){
        userRepository.delete(user);
    }

}

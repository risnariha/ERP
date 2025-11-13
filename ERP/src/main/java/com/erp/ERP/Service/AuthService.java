package com.erp.ERP.Service;

import com.erp.ERP.Model.User;
import com.erp.ERP.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> userOpt = Optional.ofNullable(userRepo.findByUsername(username));
        User user = userOpt.orElseThrow(() -> new RuntimeException("User not found"));
        // Map your User entity to org.springframework.security.core.userdetails.User as needed.
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles())
                .build();
    }
}

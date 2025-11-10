package com.erp.ERP.Repository;


import com.erp.ERP.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    // Add custom query methods if needed (e.g., findByUsername)
    User findByUsername(String username);
}

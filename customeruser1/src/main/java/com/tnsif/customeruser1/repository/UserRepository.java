package com.tnsif.customeruser1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tnsif.customeruser1.user.User;

@Repository // ✅ Added for clarity
public interface UserRepository extends JpaRepository<User, Integer> {

    // ✅ Optional custom query methods
    User findByUsername(String username);
    User findByEmail(String email);
}
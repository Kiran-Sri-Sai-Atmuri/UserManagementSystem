package com.kiran.UserManagementSystem.Repository;

import com.kiran.UserManagementSystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByUserName(String userName);
}

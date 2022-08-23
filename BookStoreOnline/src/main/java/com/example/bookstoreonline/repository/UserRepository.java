package com.example.bookstoreonline.repository;

import com.example.bookstoreonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
    User getUserByVerificationCode(String verifyCode);
}

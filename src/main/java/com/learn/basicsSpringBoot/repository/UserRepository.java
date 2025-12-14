package com.learn.basicsSpringBoot.repository;

import com.learn.basicsSpringBoot.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {

    Optional<user> findByEmail(String email);
}

package com.inn.cashflow.server.core.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.cashflow.server.core.users.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

    Optional<Users> findByUsername(String username);

    Optional<Users> findByEmail(String email);
}

package com.klgroup.connectify.repository;

import com.klgroup.connectify.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, UUID> {
    Optional<BaseUser> findByUsername(String username);
    Boolean existsByUsername(String username);
}

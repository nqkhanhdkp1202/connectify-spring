package com.klgroup.connectify.repository;

import com.klgroup.connectify.model.EndUser;

import java.util.Optional;

public interface EndUserRepository {
    Optional<EndUser> getUserInfo(String token);

}

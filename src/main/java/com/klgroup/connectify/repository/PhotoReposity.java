package com.klgroup.connectify.repository;

import com.klgroup.connectify.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PhotoReposity extends JpaRepository<Photo, UUID> {
    List<Photo> findPhotoById(UUID id);
}

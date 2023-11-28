package com.klgroup.connectify.repository;

import com.klgroup.connectify.model.Admin;
import com.klgroup.connectify.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByTitle(String title);
}

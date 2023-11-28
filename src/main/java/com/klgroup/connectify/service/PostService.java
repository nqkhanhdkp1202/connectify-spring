package com.klgroup.connectify.service;

import com.klgroup.connectify.model.Post;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
}

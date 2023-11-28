package com.klgroup.connectify.service.impl;

import com.klgroup.connectify.model.Post;
import com.klgroup.connectify.repository.PostRepository;
import com.klgroup.connectify.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}

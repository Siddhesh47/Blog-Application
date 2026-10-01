package com.bms.blog.services;

import com.bms.blog.domain.CreatePostRequest;
import com.bms.blog.domain.UpdatePostRequest;
import com.bms.blog.domain.entities.Post;
import com.bms.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);

    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
}

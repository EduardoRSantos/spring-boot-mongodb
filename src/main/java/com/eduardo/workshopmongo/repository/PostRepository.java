package com.eduardo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eduardo.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
}

package com.eduardo.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.eduardo.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchtitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String text);
}

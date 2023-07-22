package com.eduardo.workshopmongo.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eduardo.workshopmongo.entities.User;

public interface UserRepository extends MongoRepository<User, Serializable> {
    
}

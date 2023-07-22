package com.eduardo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.workshopmongo.dto.UserDTO;
import com.eduardo.workshopmongo.entities.User;
import com.eduardo.workshopmongo.repository.UserRepository;

@Service
public class UserService {
    

    @Autowired
    private UserRepository repository;
    
    public List<UserDTO> findAll(){
        List<User> list = repository.findAll();
        return list.stream().map(x -> new UserDTO(x)).toList();
    }
    
    

}

package com.eduardo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.workshopmongo.dto.UserDTO;
import com.eduardo.workshopmongo.entities.User;
import com.eduardo.workshopmongo.repository.UserRepository;
import com.eduardo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
    

    @Autowired
    private UserRepository repository;
    
    public List<UserDTO> findAll(){
        List<User> list = repository.findAll();
        return list.stream().map(x -> new UserDTO(x)).toList();
    }
    
    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}

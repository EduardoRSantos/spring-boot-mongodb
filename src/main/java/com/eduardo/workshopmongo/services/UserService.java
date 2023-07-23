package com.eduardo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eduardo.workshopmongo.dto.UserDTO;
import com.eduardo.workshopmongo.entities.User;
import com.eduardo.workshopmongo.repository.UserRepository;
import com.eduardo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(x -> new UserDTO(x)).toList();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void deleteById(String id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException(id);
        }
    }

    public User update(User obj){
        User newObj = findById(obj.getId());
        updateUser(newObj, obj);
        return repository.save(newObj);
    }

    private void updateUser(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(),obj.getName(),obj.getEmail());
    }

}

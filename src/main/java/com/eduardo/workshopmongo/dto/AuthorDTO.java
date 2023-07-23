package com.eduardo.workshopmongo.dto;


import java.io.Serializable;

import com.eduardo.workshopmongo.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO implements Serializable {
    
    private String id;
    private String name;
    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

    
}

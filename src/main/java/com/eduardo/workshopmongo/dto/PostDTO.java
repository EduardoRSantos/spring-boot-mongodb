package com.eduardo.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.eduardo.workshopmongo.entities.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO implements Serializable {

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    public PostDTO(Post obj){
        id = obj.getId();
        date = obj.getDate();
        title = obj.getTitle();
        body = obj.getBody();
        author = obj.getAuthor();
    }

}

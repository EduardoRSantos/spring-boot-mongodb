package com.eduardo.workshopmongo.dto;

import java.time.Instant;

import com.eduardo.workshopmongo.entities.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

    private String id;
    private Instant date;
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

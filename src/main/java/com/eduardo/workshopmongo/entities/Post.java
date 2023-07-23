package com.eduardo.workshopmongo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eduardo.workshopmongo.dto.AuthorDTO;
import com.eduardo.workshopmongo.dto.CommentDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Post implements Serializable {

    @Id
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd'Z'", timezone = "GMT")

    private Instant date;

    private String title;
    private String body;
    private AuthorDTO author;
    private List<CommentDTO> comments = new ArrayList<>();
    
    public Post(String id, Instant date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    
}

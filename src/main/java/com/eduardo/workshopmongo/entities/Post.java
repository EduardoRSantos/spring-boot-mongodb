package com.eduardo.workshopmongo.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

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

    private User author;
}

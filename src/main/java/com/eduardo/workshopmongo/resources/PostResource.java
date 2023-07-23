package com.eduardo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.workshopmongo.dto.PostDTO;
import com.eduardo.workshopmongo.entities.Post;
import com.eduardo.workshopmongo.resources.util.URL;
import com.eduardo.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {
    
    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(new PostDTO(obj));
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> searchfindById(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(service.findByTitle(text));
    }

    
}

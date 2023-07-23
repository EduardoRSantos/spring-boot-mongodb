package com.eduardo.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.eduardo.workshopmongo.dto.AuthorDTO;
import com.eduardo.workshopmongo.entities.Post;
import com.eduardo.workshopmongo.entities.User;
import com.eduardo.workshopmongo.repository.PostRepository;
import com.eduardo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRespository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRespository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,Instant.now(),"Partiu viagem","Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null,Instant.now(),"Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRespository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);

    }

}

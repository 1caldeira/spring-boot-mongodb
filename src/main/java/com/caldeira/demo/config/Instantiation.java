package com.caldeira.demo.config;

import com.caldeira.demo.domain.Post;
import com.caldeira.demo.domain.User;
import com.caldeira.demo.dto.AuthorDTO;
import com.caldeira.demo.repository.PostRepository;
import com.caldeira.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        AuthorDTO dto = new AuthorDTO(maria.getId(), maria.getName());


        Post post1 = new Post(null,sdf.parse("21/03/2024").toInstant(),"Partiu viagem", "Vou viajar pra Assis. Abraços!",dto);
        Post post2 = new Post(null,sdf.parse("21/03/2024").toInstant(),"Bom dia!", "Acordei feliz hoje!", dto);

        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}

package com.caldeira.demo.service;

import com.caldeira.demo.domain.Post;
import com.caldeira.demo.repository.PostRepository;
import com.caldeira.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found! Request Id: "+id));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
    
}

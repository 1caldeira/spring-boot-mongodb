package com.caldeira.demo.resources;

import com.caldeira.demo.domain.Post;

import com.caldeira.demo.resources.util.URL;
import com.caldeira.demo.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        String decodedParam = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(decodedParam);
        return ResponseEntity.ok().body(posts);
    }

}

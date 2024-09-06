package com.caldeira.demo.repository;

import com.caldeira.demo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}

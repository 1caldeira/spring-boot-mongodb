package com.caldeira.demo.repository;

import com.caldeira.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

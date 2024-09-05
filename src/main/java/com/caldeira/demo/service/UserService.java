package com.caldeira.demo.service;

import com.caldeira.demo.domain.User;
import com.caldeira.demo.dto.UserDTO;
import com.caldeira.demo.repository.UserRepository;
import com.caldeira.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found! Request Id: "+id));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO (UserDTO dto){
        return new User(dto.id(), dto.name(), dto.email());
    }
}

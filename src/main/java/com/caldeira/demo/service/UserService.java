package com.caldeira.demo.service;

import com.caldeira.demo.domain.User;
import com.caldeira.demo.dto.UserResponseDTO;
import com.caldeira.demo.dto.UserUpdateDTO;
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

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public void update(UserUpdateDTO dto){
        User entity = repo.findById(dto.id()).orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: "+dto.id()));
        updateUser(entity, dto);
    }

    private void updateUser(User entity, UserUpdateDTO dto) {
        boolean updated = false;
        if(dto.name() != null){
            entity.setName(dto.name());
            updated = true;
        }
        if(dto.email() != null){
            entity.setEmail(dto.email());
            updated = true;
        }
        if(updated){
            repo.save(entity);
        }
    }

    public User fromResponseDTO (UserResponseDTO dto){
        return new User(dto.id(), dto.name(), dto.email());
    }

}

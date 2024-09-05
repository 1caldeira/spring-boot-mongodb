package com.caldeira.demo.resources;

import com.caldeira.demo.domain.User;
import com.caldeira.demo.dto.UserResponseDTO;
import com.caldeira.demo.dto.UserUpdateDTO;
import com.caldeira.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserResponseDTO> dtos = list.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserResponseDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserResponseDTO dto){
        User user = service.fromResponseDTO(dto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserUpdateDTO> update(@RequestBody UserUpdateDTO dto, @PathVariable String id){
        UserUpdateDTO dtoWithId = new UserUpdateDTO(id, dto.name(), dto.email());
        service.update(dtoWithId);
        return ResponseEntity.noContent().build();
    }
}

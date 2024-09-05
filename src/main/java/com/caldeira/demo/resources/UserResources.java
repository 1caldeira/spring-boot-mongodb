package com.caldeira.demo.resources;

import com.caldeira.demo.domain.User;
import com.caldeira.demo.dto.UserDTO;
import com.caldeira.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> dtos = list.stream()
                .map(u -> new UserDTO(u))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
}

package com.caldeira.demo.dto;

import com.caldeira.demo.domain.User;

public record UserDTO(String id, String name, String email) {

    public UserDTO(User user){
        this(user.getId(),user.getName(),user.getEmail());
    }
}

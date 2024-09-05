package com.caldeira.demo.dto;

import com.caldeira.demo.domain.User;

public record UserResponseDTO(String id, String name, String email) {

    public UserResponseDTO(User user){
        this(user.getId(),user.getName(),user.getEmail());
    }
}

package com.caldeira.demo.dto;

import com.caldeira.demo.domain.User;

public record UserUpdateDTO(String id, String name, String email) {
    public UserUpdateDTO(User user){
        this(user.getId(),user.getName(),user.getEmail());
    }
}

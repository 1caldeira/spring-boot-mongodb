package com.caldeira.demo.dto;

import com.caldeira.demo.domain.User;

public record AuthorDTO(String id, String name) {
    public AuthorDTO(User user){
        this(user.getId(),user.getName());
    }
}

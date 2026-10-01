package com.bms.blog.services;

import com.bms.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserByID(UUID id);
}

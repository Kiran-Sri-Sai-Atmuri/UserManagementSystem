package com.kiran.UserManagementSystem.mapping;

import com.kiran.UserManagementSystem.DTO.UserDTO;
import com.kiran.UserManagementSystem.model.Users;
import com.kiran.UserManagementSystem.model.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTO {

    @Autowired
    private PasswordEncoder encode;

    public void map(Users user, UserDTO dto) {
        user.setUserName(dto.getUserName());
        user.setPassword(encode.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setRole(Role.ROLE_USER);
    }
}

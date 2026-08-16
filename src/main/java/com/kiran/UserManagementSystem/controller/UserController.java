package com.kiran.UserManagementSystem.controller;


import com.kiran.UserManagementSystem.DTO.UserDTO;
import com.kiran.UserManagementSystem.model.Users;
import com.kiran.UserManagementSystem.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(
        name = "User controller",
        description = "It controls all user requests"
)
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/admin/getAllUsers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/getById/{id}")
    public Users getById(@Parameter(
            description = "keep user id to get the details of that user",
            example = "10"
    ) @PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/auth/register")
    @Operation(
            summary = "CREATE USER REST API",
            description = "Api responsible to create user",
            tags = "some tags "
    )
    @ApiResponse(
            responseCode = "200",
            description = "User created successfully"
    )
    public String addUser(@RequestBody UserDTO dto) {
        return service.addUser(dto);
    }


    @PutMapping("/users/updateUser")
    public String updateUser(@RequestBody UserDTO dto) {
        return service.updateUser(dto);
    }

    @DeleteMapping("/users/deleteById/{id}")
    public String deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }


    @PostMapping("/makeAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String makeAdmin(@PathVariable Long id) {
        return service.makeAdmin(id);
    }


}

package com.kiran.UserManagementSystem.service;

import com.kiran.UserManagementSystem.DTO.UserDTO;
import com.kiran.UserManagementSystem.Repository.UserRepo;
import com.kiran.UserManagementSystem.mapping.UserToUserDTO;
import com.kiran.UserManagementSystem.model.Users;
import com.kiran.UserManagementSystem.model.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserToUserDTO mapper;

    public String addUser(UserDTO dto) {
        Users user = new Users();
        mapper.map(user,dto);
//        user.setUserName(dto.getUserName());
//        user.setEmail(dto.getEmail());
//        user.setPhoneNumber(dto.getPhoneNumber());
//        user.setRole(Role.ROLE_USER);
//        user.setPassword(encoder.encode(dto.getPassword()));
        repo.save(user);
        return "Successfully added";
    }

    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    public String updatePassword(String password) {
        Users user = getUsers();
        if (user == null)
            return "user not found";
        user.setPassword(encoder.encode(password));
        repo.save(user);
        return "*** Successfully Updated ***";
    }

    public String updateUser(UserDTO dto) {
        Users user = getUsers();
        if(!user.getUsername().equals(dto.getUserName())){
            return "Wrong user";
        }
        if (user == null)
            return "user not found";
        mapper.map(user,dto);
        repo.save(user);
        return "Successfully updated";
    }

    private Users getUsers() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user=repo.findByUserName(name).orElse(null);
        if(user==null)
            return null;
        return user;
    }

    public String makeAdmin(Long id) {
        Users user = repo.findById(id).orElse(null);
        if(user==null)
            return "User not found";
        user.setRole(Role.ROLE_ADMIN);
        repo.save(user);
        return "User marked as ADMIN";
    }

    public Users getById(Long id) {
        return repo.findById(id).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }

    public String deleteUser(Long id) {
        repo.deleteById(id);
        return "Successfully Deleted";
    }
}

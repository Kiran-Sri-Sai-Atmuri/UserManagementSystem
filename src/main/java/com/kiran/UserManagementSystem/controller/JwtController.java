package com.kiran.UserManagementSystem.controller;

import com.kiran.UserManagementSystem.DTO.Auth;
import com.kiran.UserManagementSystem.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/auth/login")
    public String jwtToken(@RequestBody Auth auth){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    auth.getUserName(),auth.getPassword()
            ));
            return jwtUtil.generateToken(auth.getUserName());
        }catch (Exception e){
            throw e;
        }
    }

}

package com.kiran.UserManagementSystem.audit;

import com.kiran.UserManagementSystem.model.Users;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class JpaAudit implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null||!authentication.isAuthenticated()|| authentication instanceof AnonymousAuthenticationToken)
            return Optional.of("SYSTEM");
        Users user = (Users)authentication.getPrincipal();
        return Optional.ofNullable(user.getUsername());
    }
}

package com.kiran.UserManagementSystem.model.type;

import java.util.HashSet;
import java.util.Set;

public enum Role {
    ROLE_ADMIN(Set.of(Permissions.READ,Permissions.WRITE,Permissions.DELETE,Permissions.UPDATE)),
    ROLE_USER(Set.of(Permissions.READ));

    private final Set<Permissions> permissionsSet;

    Role(Set<Permissions> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

    public Set<Permissions> getPermissionsSet(){
        return permissionsSet;
    }
}

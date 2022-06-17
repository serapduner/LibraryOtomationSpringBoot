package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getAllPermissions();

    Permission savePermission (Permission permission);

    Permission addPermission (Permission permission);

    Permission getPermissionById(long id);

    void deletePermissionById(long id);
}

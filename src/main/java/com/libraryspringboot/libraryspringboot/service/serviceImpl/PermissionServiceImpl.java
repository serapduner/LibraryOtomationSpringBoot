package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Permission;
import com.libraryspringboot.libraryspringboot.repository.PermissionRepository;
import com.libraryspringboot.libraryspringboot.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission savePermission(Permission permission) {
        this.permissionRepository.save(permission);
        return permission;
    }

    @Override
    public Permission addPermission(Permission permission) {
        this.permissionRepository.save(permission);
        return permission;
    }

    @Override
    public Permission getPermissionById(long id) {
        Optional<Permission> optional = permissionRepository.findById(id);
        Permission permission = null;
        if (optional.isPresent()) {
            permission = optional.get();
        } else {
            throw new RuntimeException(" permission not found for id :: " + id);
        }
        return permission;
    }

    @Override
    public void deletePermissionById(long id) {

        this.permissionRepository.deleteById(id);
    }
}

package com.libraryspringboot.libraryspringboot.service.serviceImpl;

import com.libraryspringboot.libraryspringboot.model.Book;
import com.libraryspringboot.libraryspringboot.model.MemberPermission;
import com.libraryspringboot.libraryspringboot.repository.MemberPermissionRepository;
import com.libraryspringboot.libraryspringboot.service.MemberPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberPermissionServiceImpl implements MemberPermissionService {

    private final MemberPermissionRepository memberPermissionRepository;

    public MemberPermissionServiceImpl(MemberPermissionRepository memberPermissionRepository) {
        this.memberPermissionRepository = memberPermissionRepository;
    }

    @Override
    public List<MemberPermission> getALlMemberPermissions() {
        return memberPermissionRepository.findAll();
    }

    @Override
    public MemberPermission saveMemberPermission(MemberPermission memberPermission) {
        this.memberPermissionRepository.save(memberPermission);
        return memberPermission;
    }

    @Override
    public MemberPermission addMemberPermission(MemberPermission memberPermission) {
        this.memberPermissionRepository.save(memberPermission);
        return memberPermission;
    }

    @Override
    public MemberPermission getMemberPermissionById(long id) {
        Optional<MemberPermission> optional = memberPermissionRepository.findById(id);
        MemberPermission memberPermission = null;
        if (optional.isPresent()) {
            memberPermission = optional.get();
        } else {
            throw new RuntimeException(" memberpermission not found for id :: " + id);
        }
        return memberPermission;
    }

    @Override
    public void deleteMemberPermissionById(long id) {
        this.memberPermissionRepository.deleteById(id);
    }
}

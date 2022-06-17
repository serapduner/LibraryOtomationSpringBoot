package com.libraryspringboot.libraryspringboot.service;

import com.libraryspringboot.libraryspringboot.model.MemberPermission;

import java.util.List;

public interface MemberPermissionService {
    List<MemberPermission> getALlMemberPermissions();

    MemberPermission saveMemberPermission(MemberPermission memberPermission);

    MemberPermission addMemberPermission(MemberPermission memberPermission);

    MemberPermission getMemberPermissionById(long id);

    void deleteMemberPermissionById(long id);
}

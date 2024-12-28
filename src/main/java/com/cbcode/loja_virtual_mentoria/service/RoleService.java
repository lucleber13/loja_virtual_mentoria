package com.cbcode.loja_virtual_mentoria.service;

import com.cbcode.loja_virtual_mentoria.model.Role;
import com.cbcode.loja_virtual_mentoria.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(Role role) {

        return roleRepository.save(role);
    }
}

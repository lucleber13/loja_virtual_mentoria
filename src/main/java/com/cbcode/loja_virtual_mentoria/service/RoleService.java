package com.cbcode.loja_virtual_mentoria.service;

import com.cbcode.loja_virtual_mentoria.model.Role;
import com.cbcode.loja_virtual_mentoria.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public List<Role> findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}

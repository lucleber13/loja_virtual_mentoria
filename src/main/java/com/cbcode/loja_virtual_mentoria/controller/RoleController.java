package com.cbcode.loja_virtual_mentoria.controller;

import com.cbcode.loja_virtual_mentoria.model.Role;
import com.cbcode.loja_virtual_mentoria.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }
}

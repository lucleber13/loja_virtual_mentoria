package com.cbcode.loja_virtual_mentoria.controller;

import com.cbcode.loja_virtual_mentoria.model.Role;
import com.cbcode.loja_virtual_mentoria.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        Role roleSaved = roleService.save(role);
        return ResponseEntity.ok(roleSaved);
    }

    @ResponseBody
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return new ResponseEntity<>("Role deleted successfully", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Role> findRole(@PathVariable Long id) {
        Role roleFound = roleService.findById(id);
        return ResponseEntity.ok(roleFound);
    }

    @ResponseBody
    @GetMapping(value = "/findByRole/{role}")
    public ResponseEntity<List<Role>> findRole(@PathVariable String role) {
        List<Role> roleFound = roleService.findByRole(role);
        return ResponseEntity.ok(roleFound);
    }
}

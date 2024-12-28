package com.cbcode.loja_virtual_mentoria;

import com.cbcode.loja_virtual_mentoria.controller.RoleController;
import com.cbcode.loja_virtual_mentoria.model.Role;
import com.cbcode.loja_virtual_mentoria.repository.RoleRepository;
import com.cbcode.loja_virtual_mentoria.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
class LojaVirtualMentoriaApplicationTests {
    @Autowired
    private RoleController roleController;

    @Test
    void testRoleRegister() {

        Role role = new Role();
        role.setRole("ROLE_ADMIN");

        roleController.save(role);
    }

}

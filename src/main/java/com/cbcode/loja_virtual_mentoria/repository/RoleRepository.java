package com.cbcode.loja_virtual_mentoria.repository;

import com.cbcode.loja_virtual_mentoria.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where upper(trim(r.role) ) like %?1%")
    List<Role> findByRole(String role);
}

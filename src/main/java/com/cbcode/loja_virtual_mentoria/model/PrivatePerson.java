package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.util.Date;

@Entity
@Table(name = "private_person")
public class PrivatePerson extends Person {

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public PrivatePerson() {
    }

    public PrivatePerson(Long id, String name, String email, String phone, String cpf, Date birthDate) {
        super(id, name, email, phone);
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}

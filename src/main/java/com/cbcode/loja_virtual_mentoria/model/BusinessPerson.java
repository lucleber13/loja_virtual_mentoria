package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;

@Entity
@Table(name = "business_person")
public class BusinessPerson extends Person {

    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    private String countyRegistration;
    private String townRegistration;
    private String fantasyName;
    private String companyName;
    private String category;

    public BusinessPerson() {
    }

    public BusinessPerson(Long id, String name, String email, String phone, String cnpj, String countyRegistration, String townRegistration, String fantasyName, String companyName, String category) {
        super(id, name, email, phone);
        this.cnpj = cnpj;
        this.countyRegistration = countyRegistration;
        this.townRegistration = townRegistration;
        this.fantasyName = fantasyName;
        this.companyName = companyName;
        this.category = category;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCountyRegistration() {
        return countyRegistration;
    }

    public void setCountyRegistration(String countyRegistration) {
        this.countyRegistration = countyRegistration;
    }

    public String getTownRegistration() {
        return townRegistration;
    }

    public void setTownRegistration(String townRegistration) {
        this.townRegistration = townRegistration;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

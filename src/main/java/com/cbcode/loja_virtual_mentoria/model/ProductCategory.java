package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_category")
@SequenceGenerator(name = "default_gen", sequenceName = "product_category_id_seq", allocationSize = 1)
public class ProductCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    private Long id;

    @Column(name = "name_description", nullable = false)
    private String nameDescription;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String nameDescription) {
        this.id = id;
        this.nameDescription = nameDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductCategory that)) return false;
        return Objects.equals(id, that.id)
                && Objects.equals(nameDescription, that.nameDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameDescription);
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", nameDescription='" + nameDescription + '\'' +
                '}';
    }
}

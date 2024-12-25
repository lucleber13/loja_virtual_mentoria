package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_brand")
@SequenceGenerator(name = "product_brand_seq", sequenceName = "product_brand_seq", allocationSize = 1, initialValue = 1)
public class ProductBrand implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_brand_seq")
    private Long id;

    @Column(name = "name_description", nullable = false)
    private String nameDescription;

    public ProductBrand() {
    }

    public ProductBrand(Long id, String nameDescription) {
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
        if (!(o instanceof ProductBrand that)) return false;
        return Objects.equals(id, that.id)
                && Objects.equals(nameDescription, that.nameDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameDescription);
    }

    @Override
    public String toString() {
        return "ProductBrand{" +
                "id=" + id +
                ", nameDescription='" + nameDescription + '\'' +
                '}';
    }
}

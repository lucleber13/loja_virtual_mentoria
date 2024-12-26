package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "payment_methods")
@SequenceGenerator(name = "payment_methods_seq", sequenceName = "payment_methods_seq", allocationSize = 1)
public class PaymentMethods implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_methods_seq")
    private Long id;

    @Column(name = "description")
    private String description;

    public PaymentMethods() {
    }

    public PaymentMethods(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethods that = (PaymentMethods) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

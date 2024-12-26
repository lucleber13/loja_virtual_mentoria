package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "image_product")
@SequenceGenerator(name = "image_product_seq", sequenceName = "image_product_seq", allocationSize = 1)
public class ImageProduct implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_product_seq")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String originalImage;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String smallImage;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "product_fk", value = ConstraintMode.CONSTRAINT))
    private Product product;

    public ImageProduct() {
    }

    public ImageProduct(String originalImage, String smallImage, Product product) {
        this.originalImage = originalImage;
        this.smallImage = smallImage;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(String originalImage) {
        this.originalImage = originalImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ImageProduct that = (ImageProduct) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

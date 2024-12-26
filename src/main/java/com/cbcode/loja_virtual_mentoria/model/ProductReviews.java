package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a product reviews.
 * This class is used to store information about a product reviews.
 */
@Entity
@Table(name = "product_reviews")
@SequenceGenerator(name = "product_reviews_seq", sequenceName = "product_reviews_seq", allocationSize = 1)
public class ProductReviews implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_reviews_seq")
    private Long id;

    private Integer rating;

    private String review;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_product", value = ConstraintMode.CONSTRAINT))
    private Product product;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_person", value = ConstraintMode.CONSTRAINT))
    private Person person;

    public ProductReviews() {
    }

    public ProductReviews(Integer rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductReviews that = (ProductReviews) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

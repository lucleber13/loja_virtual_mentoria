package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long id;

    @Column(name = "unity_type", nullable = false)
    private String unityType;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean active = Boolean.TRUE;


    @Column(columnDefinition = "TEXT", length = 2000, nullable = false) // This column can store up to 2000 characters in the database table column definition
    private String description;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double length;

    @Column(name = "sale_price", nullable = false)
    private BigDecimal salePrice = BigDecimal.ZERO;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity = 0;
    private Integer minimumStockQuantity = 0;
    private String youtubeUrl;
    private Boolean alertStockQuantity = Boolean.FALSE;
    private Integer clickCount = 0;

    public Product() {
    }

    public Product(String unityType, String name, String description, Double weight, Double width, Double height, Double length, BigDecimal salePrice,
                   Integer stockQuantity, Integer minimumStockQuantity, String youtubeUrl, Boolean alertStockQuantity) {
        this.unityType = unityType;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
        this.salePrice = salePrice;
        this.stockQuantity = stockQuantity;
        this.minimumStockQuantity = minimumStockQuantity;
        this.youtubeUrl = youtubeUrl;
        this.alertStockQuantity = alertStockQuantity;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnityType() {
        return unityType;
    }

    public void setUnityType(String unityType) {
        this.unityType = unityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getMinimumStockQuantity() {
        return minimumStockQuantity;
    }

    public void setMinimumStockQuantity(Integer minimumStockQuantity) {
        this.minimumStockQuantity = minimumStockQuantity;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public Boolean getAlertStockQuantity() {
        return alertStockQuantity;
    }

    public void setAlertStockQuantity(Boolean alertStockQuantity) {
        this.alertStockQuantity = alertStockQuantity;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

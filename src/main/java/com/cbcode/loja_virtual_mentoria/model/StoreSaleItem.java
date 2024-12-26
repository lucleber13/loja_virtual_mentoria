package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a sale item in the store.
 * This class is used to store information about a sale item in the store.
 */
@Entity
@Table(name = "store_sale_item")
@SequenceGenerator(name = "default_gen", sequenceName = "store_sale_item_seq", allocationSize = 1)
public class StoreSaleItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    private Long id;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_product", value = ConstraintMode.CONSTRAINT))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "online_store_transaction_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_online_store_transaction", value = ConstraintMode.CONSTRAINT))
    private OnlineStoreTransaction onlineStoreTransaction;

    public StoreSaleItem() {
    }

    public StoreSaleItem(Double quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OnlineStoreTransaction getOnlineStoreTransaction() {
        return onlineStoreTransaction;
    }

    public void setOnlineStoreTransaction(OnlineStoreTransaction onlineStoreTransaction) {
        this.onlineStoreTransaction = onlineStoreTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StoreSaleItem that = (StoreSaleItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

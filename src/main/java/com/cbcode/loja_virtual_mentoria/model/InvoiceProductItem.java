package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "invoice_product_item")
@SequenceGenerator(name = "invoice_product_item_seq", sequenceName = "invoice_product_item_seq", allocationSize = 1)
public class InvoiceProductItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_product_item_seq")
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "product_fk", value = ConstraintMode.CONSTRAINT))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "invoice_buyer_id", nullable = false, foreignKey = @ForeignKey(name = "invoice_buyer_fk", value = ConstraintMode.CONSTRAINT))
    private PurchaseInvoice purchaseInvoice;

    public InvoiceProductItem() {
    }

    public InvoiceProductItem(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseInvoice getInvoiceBuyer() {
        return purchaseInvoice;
    }

    public void setInvoiceBuyer(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceProductItem that = (InvoiceProductItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

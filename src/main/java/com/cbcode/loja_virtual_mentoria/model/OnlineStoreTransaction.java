package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Represents an online store transaction.
 * This class is used to store information about an online store transaction.
 */
@Entity
@Table(name = "online_store_transaction")
@SequenceGenerator(name = "online_store_transaction_seq", sequenceName = "online_store_transaction_seq", allocationSize = 1)
public class OnlineStoreTransaction implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "online_store_transaction_seq")
    private Long id;

    @ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_person", value = ConstraintMode.CONSTRAINT))
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_delivery_address", value = ConstraintMode.CONSTRAINT))
    private Address deliveryAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_billing_address", value = ConstraintMode.CONSTRAINT))
    private Address billingAddress;

    @Column(nullable = false)
    private BigDecimal totalValue;

    private BigDecimal discountValue;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_payment_method", value = ConstraintMode.CONSTRAINT))
    private PaymentMethods paymentMethod;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sales_invoice_id", nullable = true,
            foreignKey = @ForeignKey(name = "fk_sales_invoice", value = ConstraintMode.CONSTRAINT))
    private SalesInvoice salesInvoice;

    @ManyToOne
    @JoinColumn(name = "discount_coupon_id",
            foreignKey = @ForeignKey(name = "fk_discount_coupon", value = ConstraintMode.CONSTRAINT))
    private DiscountCoupon discountCoupon;

    @Column(nullable = false)
    private BigDecimal deliveryFee;

    @Column(nullable = false)
    private Integer deliveryTimeInDays;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    public OnlineStoreTransaction() {
    }

    public OnlineStoreTransaction(BigDecimal totalValue, BigDecimal discountValue, BigDecimal deliveryFee, Integer deliveryTimeInDays, Date deliveryDate, Date saleDate) {
        this.totalValue = totalValue;
        this.discountValue = discountValue;
        this.deliveryFee = deliveryFee;
        this.deliveryTimeInDays = deliveryTimeInDays;
        this.deliveryDate = deliveryDate;
        this.saleDate = saleDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }

    public DiscountCoupon getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(DiscountCoupon discountCoupon) {
        this.discountCoupon = discountCoupon;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getDeliveryTimeInDays() {
        return deliveryTimeInDays;
    }

    public void setDeliveryTimeInDays(Integer deliveryTimeInDays) {
        this.deliveryTimeInDays = deliveryTimeInDays;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OnlineStoreTransaction that = (OnlineStoreTransaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

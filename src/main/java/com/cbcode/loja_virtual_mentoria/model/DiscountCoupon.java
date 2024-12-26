package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "discount_coupon")
@SequenceGenerator(name = "discount_coupon_seq", sequenceName = "discount_coupon_seq", allocationSize = 1)
public class DiscountCoupon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_coupon_seq")
    private Long id;

    @Column(name = "code_discount", nullable = false)
    private String codeDiscount;
    private BigDecimal discountValue;
    private BigDecimal realValueDiscount;
    @Column(name = "expiration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public DiscountCoupon() {
    }

    public DiscountCoupon(String codeDiscount, BigDecimal discountValue, BigDecimal realValueDiscount, Date expirationDate) {
        this.codeDiscount = codeDiscount;
        this.discountValue = discountValue;
        this.realValueDiscount = realValueDiscount;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeDiscount() {
        return codeDiscount;
    }

    public void setCodeDiscount(String codeDiscount) {
        this.codeDiscount = codeDiscount;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getRealValueDiscount() {
        return realValueDiscount;
    }

    public void setRealValueDiscount(BigDecimal realValueDiscount) {
        this.realValueDiscount = realValueDiscount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCoupon that = (DiscountCoupon) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DiscountCoupon{" +
                "id=" + id +
                ", codeDiscount='" + codeDiscount + '\'' +
                ", discountValue=" + discountValue +
                ", realValueDiscount=" + realValueDiscount +
                ", expirationDate=" + expirationDate +
                '}';
    }
}

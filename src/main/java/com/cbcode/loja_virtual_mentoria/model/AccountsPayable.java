package com.cbcode.loja_virtual_mentoria.model;

import com.cbcode.loja_virtual_mentoria.enums.AccountsPaymentStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "accounts_payable")
@SequenceGenerator(name = "accounts_payable_seq", sequenceName = "accounts_payable_seq", allocationSize = 1)
public class AccountsPayable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_payable_seq")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountsPaymentStatus status;

    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @Column(name = "discount_value")
    private BigDecimal discountValue;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "person_fk", value = ConstraintMode.CONSTRAINT))
    private Person person;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_sup_id", nullable = false, foreignKey = @ForeignKey(name = "person_sup_fk", value = ConstraintMode.CONSTRAINT))
    private Person person_supplier;

    public AccountsPayable() {
    }

    public AccountsPayable(Long id, String description, AccountsPaymentStatus status, Date dueDate, Date paymentDate, BigDecimal totalValue, BigDecimal discountValue) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.totalValue = totalValue;
        this.discountValue = discountValue;
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

    public AccountsPaymentStatus getStatus() {
        return status;
    }

    public void setStatus(AccountsPaymentStatus status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPersonSupplier() {
        return person_supplier;
    }

    public void setPersonSupplier(Person person_supplier) {
        this.person_supplier = person_supplier;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountsPayable that = (AccountsPayable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AccountsReceivable{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", totalValue=" + totalValue +
                ", discountValue=" + discountValue +
                ", person=" + person +
                ", person_supplier=" + person_supplier +
                '}';
    }
}

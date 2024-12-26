package com.cbcode.loja_virtual_mentoria.model;

import com.cbcode.loja_virtual_mentoria.enums.AccountsReceivableStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "accounts_receivable")
@SequenceGenerator(name = "accounts_receivable_seq", sequenceName = "accounts_receivable_seq", allocationSize = 1)
public class AccountsReceivable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accounts_receivable_seq")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountsReceivableStatus status;

    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "person_fk", value = ConstraintMode.CONSTRAINT))
    private Person person;

    public AccountsReceivable() {
    }

    public AccountsReceivable(Long id, String description, AccountsReceivableStatus status, Date dueDate, Date paymentDate, BigDecimal totalValue) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.totalValue = totalValue;
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

    public AccountsReceivableStatus getStatus() {
        return status;
    }

    public void setStatus(AccountsReceivableStatus status) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountsReceivable that = (AccountsReceivable) o;
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
                ", person=" + person +
                '}';
    }
}

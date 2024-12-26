package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "invoice_buyer")
@SequenceGenerator(name = "invoice_buyer_seq", sequenceName = "invoice_buyer_seq", allocationSize = 1)
public class InvoiceBuyer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_buyer_seq")
    private Long id;

    private String invoiceNumber;
    private String invoiceSeries;
    private String description;
    private BigDecimal totalValue;
    private BigDecimal valueDiscount;
    private BigDecimal valueIcms;
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "person_fk", value = ConstraintMode.CONSTRAINT))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "accounts_payment_id", nullable = false, foreignKey = @ForeignKey(name = "accounts_payment_fk", value = ConstraintMode.CONSTRAINT))
    private AccountsPayment accountsPayment;

    public InvoiceBuyer() {
    }

    public InvoiceBuyer(String invoiceNumber, String invoiceSeries, String description, BigDecimal totalValue, BigDecimal valueDiscount, BigDecimal valueIcms, Date issueDate) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceSeries = invoiceSeries;
        this.description = description;
        this.totalValue = totalValue;
        this.valueDiscount = valueDiscount;
        this.valueIcms = valueIcms;
        this.issueDate = issueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceSeries() {
        return invoiceSeries;
    }

    public void setInvoiceSeries(String invoiceSeries) {
        this.invoiceSeries = invoiceSeries;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getValueDiscount() {
        return valueDiscount;
    }

    public void setValueDiscount(BigDecimal valueDiscount) {
        this.valueDiscount = valueDiscount;
    }

    public BigDecimal getValueIcms() {
        return valueIcms;
    }

    public void setValueIcms(BigDecimal valueIcms) {
        this.valueIcms = valueIcms;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AccountsPayment getAccountsPayment() {
        return accountsPayment;
    }

    public void setAccountsPayment(AccountsPayment accountsPayment) {
        this.accountsPayment = accountsPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceBuyer that = (InvoiceBuyer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

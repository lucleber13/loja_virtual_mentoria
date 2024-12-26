package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a shop item sale.
 * This class is used to store information about a shop item sale.
 */
@Entity
@Table(name = "sales_invoice")
@SequenceGenerator(name = "sales_invoice_seq", sequenceName = "sales_invoice_seq", allocationSize = 1)
public class SalesInvoice implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_invoice_seq")
    private Long id;

    private String invoiceNumber;
    private String series;
    private String type;
    @Column(columnDefinition = "TEXT")
    private String xml;
    @Column(columnDefinition = "TEXT")
    private String pdf;

    @OneToOne
    @JoinColumn(name = "online_store_transaction_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_online_store_transaction", value = ConstraintMode.CONSTRAINT))
    private OnlineStoreTransaction onlineStoreTransaction;

    public SalesInvoice() {
    }

    public SalesInvoice(String invoiceNumber, String series, String type, String xml, String pdf) {
        this.invoiceNumber = invoiceNumber;
        this.series = series;
        this.type = type;
        this.xml = xml;
        this.pdf = pdf;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
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
        SalesInvoice that = (SalesInvoice) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

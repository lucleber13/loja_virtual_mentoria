package com.cbcode.loja_virtual_mentoria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a tracking status.
 * This class is used to store information about a tracking status.
 */
@Entity
@Table(name = "tracking_status")
@SequenceGenerator(name = "tracking_status_seq", sequenceName = "tracking_status_seq", allocationSize = 1)
public class TrackingStatus implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tracking_status_seq")
    private Long id;

    private String distributionCenter;
    private String city;
    private String state;
    private String status;

    @ManyToOne
    @JoinColumn(name = "online_store_transaction_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_online_store_transaction", value = ConstraintMode.CONSTRAINT))
    private OnlineStoreTransaction onlineStoreTransaction;

    public TrackingStatus() {
    }

    public TrackingStatus(String distributionCenter, String city, String state, String status) {
        this.distributionCenter = distributionCenter;
        this.city = city;
        this.state = state;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistributionCenter() {
        return distributionCenter;
    }

    public void setDistributionCenter(String distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        TrackingStatus that = (TrackingStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

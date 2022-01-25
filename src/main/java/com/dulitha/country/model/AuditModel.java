package com.dulitha.country.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdDate", "updatedDate", "expired"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    @LastModifiedDate
    private Date updatedDate;

    @Column(name = "expired", nullable = false)
    private boolean expired = false;

    public Date getCreatedAt() {
        return createdDate;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdDate = createdAt;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}


package com.udacity.vehicles.domain.car;

import com.udacity.vehicles.domain.Condition;
import com.udacity.vehicles.domain.Location;
import java.time.LocalDateTime;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Declares the Car class, related variables and methods.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Condition condition;

    @Valid
    @Embedded
    private Details details = new Details();

    @Valid
    @Embedded
    private Location location = new Location(0d, 0d);

    @Transient
    private String price;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Details getDetails() {
        return this.details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
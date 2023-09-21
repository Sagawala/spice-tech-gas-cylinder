package com.spicetech.gascylinderapp.Entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Entity
@Table(name = "cylinders")
public class Cylinder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cylinderId;

    private Long ownerId;

    private Double gasLevel;

    private Double threshold;

    // Constructors, getters, and setters


    public Cylinder(Long cylinderId, Long ownerId, Double gasLevel, Double threshold) {
        this.cylinderId = cylinderId;
        this.ownerId = ownerId;
        this.gasLevel = gasLevel;
        this.threshold = threshold;
    }

    public Long getCylinderId() {
        return cylinderId;
    }

    public void setCylinderId(Long cylinderId) {
        this.cylinderId = cylinderId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Double getGasLevel() {
        return gasLevel;
    }

    public void setGasLevel(Double gasLevel) {
        this.gasLevel = gasLevel;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }
}

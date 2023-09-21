package com.spicetech.gascylinderapp.Entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Table(name = "gas_sensors")
public class GasSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorId;

    private Long cylinderId;

    private Double reading;

    private Timestamp timestamp;

    // Constructors, getters, and setters

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Long getCylinderId() {
        return cylinderId;
    }

    public void setCylinderId(Long cylinderId) {
        this.cylinderId = cylinderId;
    }

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

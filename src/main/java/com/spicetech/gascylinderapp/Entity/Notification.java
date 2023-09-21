package com.spicetech.gascylinderapp.Entity;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notifId;

    private Long userId;

    private String message;

    private String timestamp;

    // Constructors, getters, and setters

    public Long getNotifId() {
        return notifId;
    }

    public void setNotifId(Long notifId) {
        this.notifId = notifId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

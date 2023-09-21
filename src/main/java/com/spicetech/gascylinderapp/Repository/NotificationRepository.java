package com.spicetech.gascylinderapp.Repository;


import com.spicetech.gascylinderapp.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

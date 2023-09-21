package com.spicetech.gascylinderapp.Controller;

import com.spicetech.gascylinderapp.Entity.Notification;
import com.spicetech.gascylinderapp.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) {
        Notification addedNotification = notificationService.addNotification(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedNotification);
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationService.getNotificationById(id);
        if (notification.isPresent()) {
            return ResponseEntity.ok(notification.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotificationById(@PathVariable Long id, @RequestBody Notification updatedNotification) {
        Notification notification = notificationService.updateNotificationById(id, updatedNotification);
        if (notification != null) {
            return ResponseEntity.ok(notification);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificationById(@PathVariable Long id) {
        notificationService.deleteNotificationById(id);
        return ResponseEntity.noContent().build();
    }
}

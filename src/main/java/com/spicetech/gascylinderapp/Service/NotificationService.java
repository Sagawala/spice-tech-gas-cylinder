package com.spicetech.gascylinderapp.Service;

import com.spicetech.gascylinderapp.Entity.Notification;
import com.spicetech.gascylinderapp.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public Notification updateNotificationById(Long id, Notification updatedNotification) {
        Optional<Notification> existingNotification = notificationRepository.findById(id);
        if (existingNotification.isPresent()) {
            Notification notification = existingNotification.get();
            notification.setUserId(updatedNotification.getUserId());
            notification.setMessage(updatedNotification.getMessage());
            notification.setTimestamp(updatedNotification.getTimestamp());
            return notificationRepository.save(notification);
        }
        return null;
    }

    public void deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
    }
}

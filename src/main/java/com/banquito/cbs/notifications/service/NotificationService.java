package com.banquito.cbs.notifications.service;

import com.banquito.cbs.notifications.model.Notification;
import com.banquito.cbs.notifications.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public Notification find(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public void save(Notification notification) {
        notificationRepository.save(notification);
    }

    public void destroy(Notification notification) {
        notificationRepository.delete(notification);
    }
}

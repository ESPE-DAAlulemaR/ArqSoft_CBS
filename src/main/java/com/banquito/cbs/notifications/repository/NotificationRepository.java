package com.banquito.cbs.notifications.repository;

import com.banquito.cbs.notifications.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

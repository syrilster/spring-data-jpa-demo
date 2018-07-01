package com.springboot.jpa.demo.jpain10steps.service;

import com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

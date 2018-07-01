package com.springboot.jpa.demo.jpain10steps.service;

import com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationTypeRepository extends JpaRepository<NotificationType, Integer> {
}

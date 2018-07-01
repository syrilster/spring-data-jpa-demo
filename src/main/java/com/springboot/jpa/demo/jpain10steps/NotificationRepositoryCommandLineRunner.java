package com.springboot.jpa.demo.jpain10steps;

import com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance.EmailNotification;
import com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance.NotificationType;
import com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance.SmsNotification;
import com.springboot.jpa.demo.jpain10steps.service.NotificationRepository;
import com.springboot.jpa.demo.jpain10steps.service.NotificationTypeRepository;
import com.springboot.jpa.demo.jpain10steps.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class NotificationRepositoryCommandLineRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(NotificationRepositoryCommandLineRunner.class);

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationTypeRepository notificationTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        sendSMSNotification();
        sendEmailNotification();
    }

    private void sendSMSNotification() {
        Optional<NotificationType> notificationType = notificationTypeRepository
                .findById(Integer.valueOf(NotificationType.NOTIFICATION_TYPE_SMS));
        SmsNotification smsNotification = new SmsNotification();
        smsNotification.setFirstName("Syril");
        smsNotification.setLastName("Sadasivan");
        smsNotification.setCreatedOn(new Date());
        smsNotification.setPhoneNumber("9945434485");
        smsNotification.setNotificationType(notificationType.get());
        notificationRepository.save(smsNotification);
        logger.info("Notification in the system is of type --> " + notificationRepository.findAll().get(0).getNotificationType().getLabel());

    }

    private void sendEmailNotification() {
        Optional<NotificationType> emailNotificationType = notificationTypeRepository
                .findById(Integer.valueOf(NotificationType.NOTIFICATION_TYPE_EMAIL));
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.setFirstName("Anju");
        emailNotification.setLastName("Ravindran");
        emailNotification.setCreatedOn(new Date());
        emailNotification.setEmailAddress("anju@hotmail.com");
        emailNotification.setNotificationType(emailNotificationType.get());
        notificationRepository.save(emailNotification);
        logger.info("Notification in the system is of type --> " + notificationRepository.findAll().get(0).getNotificationType().getLabel());
    }
}

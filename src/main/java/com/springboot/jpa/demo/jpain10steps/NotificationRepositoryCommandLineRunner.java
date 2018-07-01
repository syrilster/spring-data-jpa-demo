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
import java.util.Random;

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
    }

    private void sendEmailNotification() {
        Optional<NotificationType> emailNotificationType = notificationTypeRepository
                .findById(Integer.valueOf(NotificationType.NOTIFICATION_TYPE_EMAIL));
        for (int i = 0; i < 2; i++) {
            EmailNotification emailNotification = new EmailNotification();
            emailNotification.setFirstName("Anju");
            emailNotification.setLastName(getToken(8));
            emailNotification.setCreatedOn(new Date());
            emailNotification.setEmailAddress(getToken(6) + "@hotmail.com");
            emailNotification.setNotificationType(emailNotificationType.get());
            notificationRepository.save(emailNotification);
        }
    }

    private static final Random random = new Random();
    private static final String CHARS = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#$";

    public static String getToken(int length) {
        StringBuilder token = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            token.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return token.toString();
    }
}

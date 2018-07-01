package com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_notification")
@DiscriminatorValue(value = NotificationType.NOTIFICATION_TYPE_EMAIL)
public class EmailNotification extends Notification {
    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmailNotification() {
    }
}

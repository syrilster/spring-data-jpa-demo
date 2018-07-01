package com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sms_notification")
@DiscriminatorValue(value = NotificationType.NOTIFICATION_TYPE_SMS)
public class SmsNotification extends Notification {

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SmsNotification() {
    }
}

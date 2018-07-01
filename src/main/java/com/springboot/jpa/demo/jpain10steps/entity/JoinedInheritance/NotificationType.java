package com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance;

import javax.persistence.*;

@Entity
@Table(name = "notification_type")
public class NotificationType {
    public static final String NOTIFICATION_TYPE_SMS = "1";
    public static final String NOTIFICATION_TYPE_EMAIL = "2";

    @Id
    @Basic(optional = false)
    @Column(name = "notification_type_key")
    protected Integer notificationTypeKey;
    @Column(name = "notification_type_id")
    private String notificationTypeId;
    @Column(name = "label")
    private String label;

    public NotificationType() {
    }

    public Integer getNotificationTypeKey() {
        return notificationTypeKey;
    }

    public void setNotificationTypeKey(Integer notificationTypeKey) {
        this.notificationTypeKey = notificationTypeKey;
    }

    public String getNotificationTypeId() {
        return notificationTypeId;
    }

    public void setNotificationTypeId(String notificationTypeId) {
        this.notificationTypeId = notificationTypeId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

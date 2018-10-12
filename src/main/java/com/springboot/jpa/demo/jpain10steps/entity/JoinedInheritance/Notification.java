package com.springboot.jpa.demo.jpain10steps.entity.JoinedInheritance;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification")
@Inheritance(strategy = InheritanceType.JOINED)
// This might not be required for Hibernate provider. It's used in EclipseLink
//@DiscriminatorColumn(name = "notification_type_key" , discriminatorType = DiscriminatorType.INTEGER)
public abstract class Notification {

    @Id
    @GeneratedValue
    @Column(name = "notification_id", insertable = false, updatable = false, nullable = false)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    private Date createdOn;

    @JoinColumn(name = "notification_type_key", referencedColumnName = "notification_type_key")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private NotificationType notificationType;

    @Column(name = "message")
    private String message;

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

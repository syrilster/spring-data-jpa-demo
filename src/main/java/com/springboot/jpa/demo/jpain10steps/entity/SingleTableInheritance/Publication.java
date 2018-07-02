package com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="publication")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "publication_type")
public abstract class Publication {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column
    protected String title;

    //http://www.byteslounge.com/tutorials/jpa-entity-versioning-version-and-optimistic-locking
    @Version
    @Column(name = "version")
    private int version;
    @Column
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

    public Publication() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }
}

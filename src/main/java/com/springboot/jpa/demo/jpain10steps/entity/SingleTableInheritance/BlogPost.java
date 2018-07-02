package com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("blog")
public class BlogPost extends Publication {

    @Column
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

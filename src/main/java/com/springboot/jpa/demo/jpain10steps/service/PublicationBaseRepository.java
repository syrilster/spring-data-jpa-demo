package com.springboot.jpa.demo.jpain10steps.service;

import com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublicationBaseRepository<T extends Publication> extends JpaRepository<T, Long> {
    //http://blog.netgloo.com/2014/12/18/handling-entities-inheritance-with-spring-data-jpa/
    /*In the base repository you can referring the actual entity type inside a custom query
    (@Query annotation) using the #{#entityName} SpEL variable*/
    @Query("select u from #{#entityName} as u where u.title = ?1 ")
    T findByTitle(String title);
}

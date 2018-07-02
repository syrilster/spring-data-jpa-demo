package com.springboot.jpa.demo.jpain10steps.service;

import com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance.Book;

public interface BookRepository extends PublicationBaseRepository<Book> {
}

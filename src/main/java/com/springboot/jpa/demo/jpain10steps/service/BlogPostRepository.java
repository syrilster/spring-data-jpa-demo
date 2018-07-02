package com.springboot.jpa.demo.jpain10steps.service;

import com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance.BlogPost;
import com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance.Book;

public interface BlogPostRepository extends PublicationBaseRepository<BlogPost> {
}

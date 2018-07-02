package com.springboot.jpa.demo.jpain10steps;

import com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance.BlogPost;
import com.springboot.jpa.demo.jpain10steps.entity.SingleTableInheritance.Book;
import com.springboot.jpa.demo.jpain10steps.service.BlogPostRepository;
import com.springboot.jpa.demo.jpain10steps.service.BookRepository;
import com.springboot.jpa.demo.jpain10steps.service.PublicationBaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PublicationRepositoryCommandLineRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(PublicationRepositoryCommandLineRunner.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public void run(String... args) throws Exception {
        populateBookPublication();
        populateBlogPostPublication();
        System.out.println("Fetching book records -->" + bookRepository.findByTitle("Baraka").getNumberOfPages());
        System.out.println("Fetching Blog Post records -->" + blogPostRepository.findByTitle("Discussion").getUrl());
    }

    private void populateBookPublication() {
        Book book = new Book();
        book.setNumberOfPages(500);
        book.setPublishingDate(new Date());
        book.setTitle("Baraka");
        logger.info("Inserting a new publication of type Book");
        bookRepository.save(book);
    }

    private void populateBlogPostPublication() {
        BlogPost blogPost = new BlogPost();
        blogPost.setUrl("discussionhive.com");
        blogPost.setPublishingDate(new Date());
        blogPost.setTitle("Discussion Hive");
        logger.info("Inserting a new publication of type Blog Post");
        blogPostRepository.save(blogPost);
        logger.info("Modifying the inserted publication of type Blog Post");
        blogPost.setTitle("Discussion");
        blogPostRepository.save(blogPost);
    }

}

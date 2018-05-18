package com.springboot.jpa.demo.jpain10steps;

import com.springboot.jpa.demo.jpain10steps.entity.User;
import com.springboot.jpa.demo.jpain10steps.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Syril on 18-05-2018.
 */
@Component
public class UserServiceCommandLineRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceCommandLineRunner.class);

    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... strings) throws Exception {
        User user = new User("Syril", "Admin");
        long insert = userDAOService.insert(user);
        logger.info("New user has been created " + user);
    }
}

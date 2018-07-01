package com.springboot.jpa.demo.jpain10steps;

import com.springboot.jpa.demo.jpain10steps.entity.User;
import com.springboot.jpa.demo.jpain10steps.service.UserDAOService;
import com.springboot.jpa.demo.jpain10steps.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Syril on 18-05-2018.
 */
@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
        User user = new User("Anju", "Admin");
        userRepository.save(user);
        logger.info("New user has been created " + user);

        Optional<User> userWithIdOne = userRepository.findById(1L);
        logger.info("User with Id one retrieved " + userWithIdOne);

        List<User> userList = userRepository.findAll();
        logger.info("All users list " + userList);
    }
}

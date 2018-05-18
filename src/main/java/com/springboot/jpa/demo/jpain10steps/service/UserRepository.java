package com.springboot.jpa.demo.jpain10steps.service;

import com.springboot.jpa.demo.jpain10steps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Syril on 18-05-2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

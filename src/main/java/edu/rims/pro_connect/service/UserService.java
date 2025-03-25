package edu.rims.pro_connect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public int getuserId(String userEmail){
        return userRepository.findByUserEmail(userEmail).orElseThrow().getUserId();
    }

    public User getUser(String userEmail){
        return userRepository.findByUserEmail(userEmail).orElseThrow();
    }
}

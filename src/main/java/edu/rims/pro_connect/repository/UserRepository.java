package edu.rims.pro_connect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.constant.UserType;
import edu.rims.pro_connect.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUserType(UserType userType);
    List<User> findByUserNameContainingIgnoreCaseAndUserType(String userName,UserType userType);
    Optional<User> findByUserEmail(String userEmail);
}




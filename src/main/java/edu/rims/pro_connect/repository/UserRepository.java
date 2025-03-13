package edu.rims.pro_connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.constant.UserType;
import edu.rims.pro_connect.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUserType(UserType userType);
}

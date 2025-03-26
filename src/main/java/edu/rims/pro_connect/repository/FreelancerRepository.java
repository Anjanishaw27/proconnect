package edu.rims.pro_connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.constant.UserType;
import edu.rims.pro_connect.entity.Freelancer;

public interface FreelancerRepository extends JpaRepository<Freelancer, Integer> {

    List<Freelancer> findByUserType(UserType freelancer);

    Freelancer findByUserEmail(String name);

}

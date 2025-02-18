package edu.rims.pro_connect.entity;

import jakarta.persistence.*;

import java.util.List;

import edu.rims.pro_connect.constant.UserType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, length = 255)
    private String userName;

    @Column(nullable = false, unique = true, length = 255)
    private String userEmail;

    @Column(nullable = false, length = 255)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(length = 20)
    private String userPhone;

    @Column(columnDefinition = "TEXT")
    private String userBio;

    @Column(columnDefinition = "TEXT")
    private String userProfilePicture;

    @Column(columnDefinition = "TEXT")
    private String skill;

    @ManyToMany(mappedBy = "freelancers")
    private List<Skill> skills;

    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

}

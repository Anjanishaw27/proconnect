package edu.rims.pro_connect.entity;

import edu.rims.pro_connect.constant.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED) // Separate table for each subclass
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
    private UserType userType; // CLIENT or FREELANCER

    @Column(length = 20)
    private String userPhone;

    @Column(columnDefinition = "TEXT")
    private String userBio;

    @Column(columnDefinition = "TEXT")
    private String userProfilePicture;

    @Column(name = "location", length = 255)
    private String location;
}

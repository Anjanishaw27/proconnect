package edu.rims.pro_connect.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "user")

public class User1 {
    
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
    
    @Lob
    private byte[] userProfilePicture;
    
    @Column(columnDefinition = "TEXT")
    private String userBio;
    
    @Column(columnDefinition = "TEXT")
    private String skills;
    
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdDate;
    
    @Column(nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedDate;
    
    @Column(length = 255)
    private String createdBy;
    
    @Column(length = 255)
    private String updatedBy;
    
    public enum UserType {
        CLIENT, FREELANCER
    }
}
 

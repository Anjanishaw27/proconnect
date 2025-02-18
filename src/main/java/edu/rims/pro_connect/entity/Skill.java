package edu.rims.pro_connect.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "skill")

public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "skill_name", unique = true, nullable = false)
    private String skillName;

    @ManyToMany
    @JoinTable(name = "freelancer_skill", joinColumns = @JoinColumn(name = "skill_id"), inverseJoinColumns = @JoinColumn(name = "freelancer_id"))
    private List<User> freelancers;

}

package edu.rims.pro_connect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@Setter
@Getter
public class Payment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Auto-generates UUID
    @Column(name = "payment_id", length = 36, updatable = false, nullable = false)
    private String paymentId; 

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client; // Client entity

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private Freelancer freelancer; // Freelancer entity

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_id", unique = true, nullable = false, length = 100)
    private String transactionId;

    @OneToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}

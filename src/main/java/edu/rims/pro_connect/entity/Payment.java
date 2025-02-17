package edu.rims.pro_connect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import edu.rims.pro_connect.constant.PaymentMethod;
import edu.rims.pro_connect.constant.PaymentStatus;

@Entity
@Table(name = "payment")
@Setter
@Getter
public class Payment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private User freelancer;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('PENDING', 'COMPLETED', 'FAILED') DEFAULT 'PENDING'")
    private PaymentStatus status = PaymentStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, columnDefinition = "ENUM('PAYPAL', 'CREDIT_CARD', 'BANK_TRANSFER')")
    private PaymentMethod paymentMethod;

    @Column(name = "transaction_id", unique = true)
    private String transactionId;
}


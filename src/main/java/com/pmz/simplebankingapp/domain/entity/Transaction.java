package com.pmz.simplebankingapp.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "sum")
    private double sum;

    @Column(name = "purpose", nullable = false)
    private String purpose;

}

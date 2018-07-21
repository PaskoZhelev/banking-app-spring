package com.pmz.simplebankingapp.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "sum")
    private double sum;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    public Transaction() { }



    public Transaction(Card card, String iban, double sum, String purpose) {
        this.card = card;
        this.iban = iban;
        this.sum = sum;
        this.purpose = purpose;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}

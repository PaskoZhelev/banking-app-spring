package com.pmz.simplebankingapp.domain.entity;

import com.pmz.simplebankingapp.domain.enums.Currency;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(
            mappedBy = "card",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Transaction> transactions;

    @Column(name = "card_balance", nullable = false)
    private double cardBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private Currency currency;

    public Card() { }


    public Card(User user, double cardBalance, Currency currency) {
        this.user = user;
        this.cardBalance = cardBalance;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

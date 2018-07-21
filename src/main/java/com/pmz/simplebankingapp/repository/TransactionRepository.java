package com.pmz.simplebankingapp.repository;

import com.pmz.simplebankingapp.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTransactionsByCardId(long id);
}

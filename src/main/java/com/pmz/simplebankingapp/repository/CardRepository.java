package com.pmz.simplebankingapp.repository;

import com.pmz.simplebankingapp.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findCardsByUserId(long id);

    Card findCardById(long id);
}

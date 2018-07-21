package com.pmz.simplebankingapp.service;

import com.pmz.simplebankingapp.domain.entity.Card;

import java.util.List;

public interface CardService {

    List<Card> findCardsByUserId(long id);
    Card findCardById(long id);
}

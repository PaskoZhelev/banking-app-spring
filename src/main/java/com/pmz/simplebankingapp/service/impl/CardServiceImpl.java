package com.pmz.simplebankingapp.service.impl;

import com.pmz.simplebankingapp.domain.entity.Card;
import com.pmz.simplebankingapp.repository.CardRepository;
import com.pmz.simplebankingapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> findCardsByUserId(long id) {
        return cardRepository.findCardsByUserId(id);
    }

    @Override
    public Card findCardById(long id) {
        return cardRepository.findCardById(id);
    }


}

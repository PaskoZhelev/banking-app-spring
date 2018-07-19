package com.pmz.simplebankingapp.service;

import com.pmz.simplebankingapp.domain.entity.Card;
import com.pmz.simplebankingapp.domain.entity.Transaction;
import com.pmz.simplebankingapp.domain.entity.User;
import com.pmz.simplebankingapp.forms.UserCreateForm;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    List<Card> findUserCardsById(long id);
    List<Transaction> findUserTransactionsById(long id);
    User registerUser(UserCreateForm userCreateForm);
    boolean hasValidPassword(User user, String pwd);
}

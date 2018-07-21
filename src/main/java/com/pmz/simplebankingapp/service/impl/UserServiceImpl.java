package com.pmz.simplebankingapp.service.impl;

import com.pmz.simplebankingapp.constants.GeneralConstants;
import com.pmz.simplebankingapp.domain.entity.Card;
import com.pmz.simplebankingapp.domain.entity.Role;
import com.pmz.simplebankingapp.domain.entity.Transaction;
import com.pmz.simplebankingapp.domain.entity.User;
import com.pmz.simplebankingapp.forms.UserCreateForm;
import com.pmz.simplebankingapp.repository.CardRepository;
import com.pmz.simplebankingapp.repository.RoleRepository;
import com.pmz.simplebankingapp.repository.TransactionRepository;
import com.pmz.simplebankingapp.repository.UserRepository;
import com.pmz.simplebankingapp.service.CardService;
import com.pmz.simplebankingapp.service.RoleService;
import com.pmz.simplebankingapp.service.TransactionService;
import com.pmz.simplebankingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.pmz.simplebankingapp.constants.GeneralConstants.ROLE_USER;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CardService cardService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<Card> findUserCardsById(long id) {
        return cardService.findCardsByUserId(id);
    }

    @Override
    public List<Transaction> findTransactionsByCardId(long id) {
        return transactionService.findTransactionsByCardId(id);
    }

    public User registerUser(UserCreateForm userCreateForm) {
        User user = new User();

        user.setUsername(userCreateForm.getUsername());
        user.setEmail(userCreateForm.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateForm.getPassword()));

        Set<Role> roles = generateRolesSet();
        user.setRoles(roles);
        user.setCards(new ArrayList<>());

        return userRepository.save(user);
    }

    private Set<Role> generateRolesSet() {
        Role role = roleService.findByRoleName(ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    public boolean hasValidPassword(User user, String pwd) {
        return passwordEncoder.matches(pwd, user.getPassword());
    }
}

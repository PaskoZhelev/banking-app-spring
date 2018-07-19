package com.pmz.simplebankingapp.controller;

import com.pmz.simplebankingapp.auth.CustomUserDetails;
import com.pmz.simplebankingapp.auth.CustomUserDetailsService;
import com.pmz.simplebankingapp.domain.entity.Card;
import com.pmz.simplebankingapp.domain.entity.User;
import com.pmz.simplebankingapp.domain.enums.Currency;
import com.pmz.simplebankingapp.forms.AddCardForm;
import com.pmz.simplebankingapp.repository.CardRepository;
import com.pmz.simplebankingapp.service.UserService;
import com.pmz.simplebankingapp.utils.CurrencyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AddCardForm addCardForm;


    //    @ModelAttribute("currentUser")
//    public CustomUserDetails getCurrentUser(){
//        return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }

    @ModelAttribute("currentUserCards")
    public List<Card> getCurrentUserCards(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return userService.findUserCardsById(customUserDetails.getId());
    }

    @ModelAttribute("addCardForm")
    public AddCardForm getAddCardForm() {
        return addCardForm;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/add-card")
    public String processAddCard(@ModelAttribute("addCardForm") AddCardForm addCardForm,
                                 @ModelAttribute("currentUser") CustomUserDetails customUserDetails,
                                 Model model) {
        Currency currency = CurrencyUtils.convertStringToCurrency(addCardForm.getCurrency());
        String username = customUserDetails.getUsername();
        User user = userService.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username=%s was not found", username)));

        Card card = new Card(user, addCardForm.getCardBalance(), currency);
        cardRepository.save(card);
        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "redirect:/login";
    }

}

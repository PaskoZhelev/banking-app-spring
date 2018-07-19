package com.pmz.simplebankingapp.validators;

import com.pmz.simplebankingapp.forms.UserCreateForm;
import com.pmz.simplebankingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCreateFormValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserCreateForm form = (UserCreateForm) obj;
        validatePasswords(errors, form);
        validateUsername(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordConfirm())) {
            errors.rejectValue("password", "msg.PasswordNotMatch");
        }
    }

    private void validateUsername(Errors errors, UserCreateForm form) {
        //Avoid querying not valid or empty values
        if(errors.hasFieldErrors("username"))
            return;

        //Actual Validation
        if (userRepository.findUserByUsername(form.getUsername()).isPresent()) {
            errors.rejectValue("username", "msg.DuplicateUsername");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        //Avoid querying not valid or empty values
        if(errors.hasFieldErrors("email"))
            return;

        if (userRepository.findUserByEmail(form.getEmail()).isPresent()) {
            errors.rejectValue("email", "msg.DuplicateEmail");
        }
    }
}

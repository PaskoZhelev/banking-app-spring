package com.pmz.simplebankingapp.forms;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Component
public class UserCreateForm {

    @NotEmpty
    @Length(min = 2, max = 50)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordConfirm;

    @NotEmpty
    @Length(min = 2, max = 50)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

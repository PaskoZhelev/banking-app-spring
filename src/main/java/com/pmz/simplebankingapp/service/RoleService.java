package com.pmz.simplebankingapp.service;

import com.pmz.simplebankingapp.domain.entity.Card;
import com.pmz.simplebankingapp.domain.entity.Role;
import com.pmz.simplebankingapp.domain.entity.Transaction;
import com.pmz.simplebankingapp.domain.entity.User;
import com.pmz.simplebankingapp.forms.UserCreateForm;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role findByRoleName(String roleName);
}

package com.pmz.simplebankingapp.service.impl;

import com.pmz.simplebankingapp.domain.entity.Role;
import com.pmz.simplebankingapp.repository.RoleRepository;
import com.pmz.simplebankingapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}

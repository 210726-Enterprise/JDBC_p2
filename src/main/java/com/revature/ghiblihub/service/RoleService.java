package com.revature.ghiblihub.service;

import com.revature.ghiblihub.models.Role;
import com.revature.ghiblihub.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleById(Integer id) {
        return roleRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}

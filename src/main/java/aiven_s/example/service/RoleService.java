package aiven_s.example.service;

import aiven_s.example.entity.Role;
import aiven_s.example.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

        public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public List<Role> findAll(){
            return roleRepository.findAll();
    }
}

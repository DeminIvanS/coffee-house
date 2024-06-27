package aiven_s.example.dto;

import aiven_s.example.entity.Role;

import javax.swing.text.html.parser.Entity;

public record RoleDTO(Long id, String name) {
    public Role toRole(){
        return new Role(id, name);
    }
    public static RoleDTO fromRole(Role role){
        return role == null
                ? new RoleDTO(null, null)
                : new RoleDTO(role.getId(), role.getName());
    }
}
